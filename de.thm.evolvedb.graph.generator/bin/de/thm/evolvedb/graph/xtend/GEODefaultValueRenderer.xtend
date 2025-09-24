// ==============================
// Default value rendering helpers
// ==============================
package de.thm.evolvedb.graph.xtend

import org.eclipse.emf.ecore.EObject

class GEODefaultValueRenderer {

	/**
	 * Render a default value literal for a given PropertyValueType.
	 * 
	 * @param raw  – the default value coming from your model (String, Number, Boolean, java.time.*, List, Map, etc.)
	 * @param vt   – the PropertyValueType EObject (same hierarchy as in your ECORE)
	 * @return     – String literal suitable for your GEO text (or "null" if none/invalid)
	 */
	def static String toGeoDefault(Object raw, EObject vt) {
		if(raw === null) return "null"
		if(vt === null) return valueAuto(raw)

		switch vt.eClass.name {
			case "NumericType": numericDefault(raw)
			case "BooleanType": booleanDefault(raw)
			case "StringType": stringDefault(raw)
			case "TemporalTypes": temporalDefault(raw, s(vt, "type"))
			case "BinaryTypes": binaryDefault(raw)
			case "ListType": listDefault(raw, ref(vt, "type"))
			case "UnionType": valueAuto(raw) // AnyType – accept anything
			default: valueAuto(raw)
		}
	}

	// ---------- Specific formatters ----------
	private def static String numericDefault(Object raw) {
		switch raw {
			case raw instanceof java.lang.Number: raw.toString
			case raw instanceof String &&
				(raw as String).matches("[+-]?\\d+(?:[.][0-9]+)?(?:[eE][+-]?\\d+)?"): (raw as String) // already numeric string
			default: "null"
		}
	}

	private def static String booleanDefault(Object raw) {
		switch raw {
			case raw instanceof java.lang.Boolean: (raw as Boolean).toString
			case raw instanceof String && (raw as String).toLowerCase.matches("true|false"): (raw as String).toLowerCase
			default: "null"
		}
	}

	private def static String stringDefault(Object raw) {
		'"' + escape((raw instanceof String) ? raw as String : String.valueOf(raw)) + '"'
	}

	private def static String temporalDefault(Object raw, String kind) {
		// Expect ISO-8601 strings by default; if java.time.* is passed, format to ISO.
		if (raw instanceof java.time.temporal.TemporalAccessor) {
			val str = raw.toString // java.time types use ISO-8601 toString
			return '"' + escape(str) + '"'
		}
		if (raw instanceof String) {
			val s = raw as String
			// Very lightweight guards; you may plug a full parser/validator here.
			val ok = switch kind {
				case "DATE": s.matches("\\d{4}-\\d{2}-\\d{2}")
				case "LOCAL_TIME": s.matches("\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?")
				case "ZONED_TIME": s.matches("\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?(?:Z|[+-]\\d{2}:\\d{2})")
				case "LOCAL_DATETIME": s.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?")
				case "ZONED_DATETIME": s.matches(
					"\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}(:\\d{2}(?:[.][0-9]{1,9})?)?(?:Z|[+-]\\d{2}:\\d{2})")
				default: s.length > 0
			}
			return if(ok) '"' + escape(s) + '"' else "null"
		}
		// Fallback: stringify
		return '"' + escape(String.valueOf(raw)) + '"'
	}

	private def static String binaryDefault(Object raw) {
		// Allow byte[] (base64), hex String (0x...), or plain String (quoted)
		switch raw {
			case raw instanceof byte[]: '"' + java.util.Base64.encoder.encodeToString(raw as byte[]) + '"'
			case raw instanceof String && (raw as String).startsWith("0x"): raw as String
			case raw instanceof String: '"' + escape(raw as String) + '"'
			default: "null"
		}
	}

	private def static String listDefault(Object raw, EObject innerVt) {
		val iter = asIterable(raw)
		if(iter === null) return "[]"
		val rendered = newArrayList
		for (elem : iter) {
			rendered += toGeoDefault(elem, innerVt)
		}
		return "[" + rendered.join(",") + "]"
	}

	// ---------- Generic helpers ----------
	/** Auto-quote strings, keep numbers/bools as-is, lists recursively handled */
	private def static String valueAuto(Object raw) {
		switch raw {
			case raw instanceof java.lang.Number:
				raw.toString
			case raw instanceof java.lang.Boolean:
				(raw as Boolean).toString
			case raw instanceof CharSequence:
				'"' + escape(raw.toString) + '"'
			case raw instanceof byte[]:
				'"' + java.util.Base64.encoder.encodeToString(raw as byte[]) + '"'
			default: {
				val iter = asIterable(raw)
				if (iter !== null) {
					val rendered = iter.map[v|valueAuto(v)].toList
					return "[" + rendered.join(",") + "]"
				}
				// Unknown object -> stringify quoted
				'"' + escape(String.valueOf(raw)) + '"'
			}
		}
	}

	private def static String escape(String s) {
		if(s === null) return ""
		s.replace("\\", "\\\\") // \  -> \\
		.replace("\"", "\\\"") // "  -> \"
	}

	private def static Iterable<?> asIterable(Object o) {
		switch o {
			case o instanceof java.util.Collection<?>: o as java.util.Collection<?>
			case o.getClass.isArray: java.util.Arrays.asList(o)
			default: null
		}
	}

	// --- EMF helpers reused
	private def static String s(EObject o, String feature) {
		val f = o.eClass.getEStructuralFeature(feature)
		val v = if(f !== null) o.eGet(f) else null
		switch v {
			String: v
			org.eclipse.emf.common.util.Enumerator: v.toString
			default: null
		}
	}

	private def static EObject ref(EObject o, String feature) {
		val f = o.eClass.getEStructuralFeature(feature)
		if(f === null) return null
		val v = o.eGet(f)
		if(v instanceof EObject) v as EObject else null
	}
}
