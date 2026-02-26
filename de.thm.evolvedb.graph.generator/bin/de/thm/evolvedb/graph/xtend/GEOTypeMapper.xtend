// ==============================
// GEO type mapping from ECORE VT
// ==============================
package de.thm.evolvedb.graph.xtend

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature

class GeoTypeMapper {

	/** Public entry: map a PropertyValueType EObject -> GEO type string (e.g., "INT", "VARCHAR(255)?", "LIST<STRING>") */
	def static String toGeoType(EObject vt) {
		if(vt === null) return "ANY"
		val nullable = b(vt, "nullable")
		val base = switch vt.eClass.name {
			case "NumericType": numericToGeo(vt)
			case "StringType": stringToGeo(vt)
			case "BooleanType": "BOOLEAN"
			case "TemporalTypes": temporalToGeo(vt)
			case "BinaryTypes": binaryToGeo(vt)
			case "ListType": listToGeo(vt)
			case "UnionType": unionToGeo(vt)
			default: vt.eClass.name // fallback: return class name
		}
		return base + (if(nullable) "?" else "")
	}

// ---------- Helpers per subclass (work on EObject to avoid compile-time deps on generated model)
	private def static String numericToGeo(EObject vt) {
		val kind = s(vt, "type") // enum literal name e.g. INT, DECIMAL, DOUBLE, ...
		val ip = iOrNull(vt, "integralPart")
		val fp = iOrNull(vt, "fractionalPart")
		switch kind {
			case "DECIMAL": if(ip !== null && fp !== null && ip > 0) "DECIMAL(" + ip + "," + fp + ")" else "DECIMAL"
			case "FLOAT128": "FLOAT128"
			case "DOUBLE": "DOUBLE"
			case "FLOAT": "FLOAT"
			case "UINT": "UINT"
			case "INT": "INT"
		}
	}

	private def static String stringToGeo(EObject vt) {
		val kind = s(vt, "type") // VARCHAR or STRING
		val maxL = iOrNull(vt, "maxLength")
		if ("VARCHAR" == kind) {
			if(maxL !== null && maxL > 0) return "VARCHAR(" + maxL + ")" else return "VARCHAR"
		}
		return "STRING"
	}

	private def static String binaryToGeo(EObject vt) {
		val kind = s(vt, "type") // VARBINARY, BYTES, LITERAL2
		val maxL = iOrNull(vt, "maxLength")
		switch kind {
			case "VARBINARY": if(maxL !== null && maxL > 0) "VARBINARY(" + maxL + ")" else "VARBINARY"
			case "BYTES": if(maxL !== null && maxL > 0) "BYTES(" + maxL + ")" else "BYTES"
			default: kind ?: "BINARY"
		}
	}

	private def static String temporalToGeo(EObject vt) {
		val kind = s(vt, "type") // ZONED_DATETIME, LOCAL_DATETIME, DATE, ZONED_TIME, LOCAL_TIME, YEAR, ...
		switch kind {
			case "ZONED_DATETIME": "DATETIME"
			case "LOCAL_DATETIME": "LOCAL_DATETIME"
			case "DATE": "DATE"
			case "ZONED_TIME": "TIME"
			case "LOCAL_TIME": "LOCAL_TIME"
// For unit-only enums keep the name as a specialized temporal marker
			case "YEAR": "TEMPORAL<YEAR>"
			case "MONTH": "TEMPORAL<MONTH>"
			case "DAY": "TEMPORAL<DAY>"
			case "MINUTES": "TEMPORAL<MINUTES>"
			case "SUBSECONDS": "TEMPORAL<SUBSECONDS>"
			default: kind ?: "TEMPORAL"
		}
	}

	private def static String listToGeo(EObject vt) {
		val inner = ref(vt, "type")
		val innerStr = if(inner !== null) toGeoType(inner) else "ANY"
		val lb = iOrNull(vt, "lowerBound")
		val ub = iOrNull(vt, "upperBound")
		var res = "LIST<" + innerStr + ">"
		if (lb !== null && ub !== null && (lb >= 0 || ub >= 0)) {
			res = res + "[" + (if(lb !== null) lb else 0) + ".." + (if(ub !== null) ub else -1) + "]"
		}
		return res
	}

	private def static String unionToGeo(EObject vt) {
		val kind = s(vt, "type") // DynamicUnionTypes – currently AnyType
		if("AnyType" == kind || kind === null) return "ANY" else return "UNION<" + kind + ">"
	}

// ---------- EMF access helpers
	private def static String s(EObject o, String feature) {
		val f = o.eClass.getEStructuralFeature(feature)
		val v = if(f !== null) o.eGet(f) else null
		switch v {
			String: v
			org.eclipse.emf.common.util.Enumerator: v.toString // enum literal name
			default: null
		}
	}

	private def static Boolean b(EObject o, String feature) {
		val f = o.eClass.getEStructuralFeature(feature)
		val v = if(f !== null) o.eGet(f) else null
		if(v instanceof Boolean) v as Boolean else false
	}

	private def static Integer iOrNull(EObject o, String feature) {
		val f = o.eClass.getEStructuralFeature(feature)
		val v = if(f !== null) o.eGet(f) else null
		if(v instanceof Integer) v as Integer else null
	}

	private def static EObject ref(EObject o, String feature) {
		val f = o.eClass.getEStructuralFeature(feature)
		if(f === null) return null
		val v = o.eGet(f)
		if(v instanceof EObject) v as EObject else null
	}
}
