/**
 */
package de.thm.evolvedb.graph.annotation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.thm.evolvedb.graph.annotation.AnnotationFactory
 * @model kind="package"
 * @generated
 */
public interface AnnotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "annotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/annotation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "annotation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotationPackage eINSTANCE = de.thm.evolvedb.graph.annotation.impl.AnnotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.annotation.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationImpl
	 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Annotation Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ANNOTATION_TARGET = 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.annotation.impl.AnnotationEntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationEntryImpl
	 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationPackageImpl#getAnnotationEntry()
	 * @generated
	 */
	int ANNOTATION_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ENTRY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ENTRY__SOURCE = 2;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.thm.evolvedb.graph.annotation.impl.AnnotationTargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationTargetImpl
	 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationPackageImpl#getAnnotationTarget()
	 * @generated
	 */
	int ANNOTATION_TARGET = 2;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TARGET__TARGET_URI = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TARGET__ANNOTATIONS = 1;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TARGET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_TARGET_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.annotation.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see de.thm.evolvedb.graph.annotation.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.graph.annotation.Annotation#getAnnotationTarget <em>Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotation Target</em>'.
	 * @see de.thm.evolvedb.graph.annotation.Annotation#getAnnotationTarget()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_AnnotationTarget();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.annotation.AnnotationEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationEntry
	 * @generated
	 */
	EClass getAnnotationEntry();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationEntry#getKey()
	 * @see #getAnnotationEntry()
	 * @generated
	 */
	EAttribute getAnnotationEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationEntry#getValue()
	 * @see #getAnnotationEntry()
	 * @generated
	 */
	EAttribute getAnnotationEntry_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.annotation.AnnotationEntry#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationEntry#getSource()
	 * @see #getAnnotationEntry()
	 * @generated
	 */
	EAttribute getAnnotationEntry_Source();

	/**
	 * Returns the meta object for class '{@link de.thm.evolvedb.graph.annotation.AnnotationTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationTarget
	 * @generated
	 */
	EClass getAnnotationTarget();

	/**
	 * Returns the meta object for the attribute '{@link de.thm.evolvedb.graph.annotation.AnnotationTarget#getTargetURI <em>Target URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target URI</em>'.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationTarget#getTargetURI()
	 * @see #getAnnotationTarget()
	 * @generated
	 */
	EAttribute getAnnotationTarget_TargetURI();

	/**
	 * Returns the meta object for the containment reference list '{@link de.thm.evolvedb.graph.annotation.AnnotationTarget#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see de.thm.evolvedb.graph.annotation.AnnotationTarget#getAnnotations()
	 * @see #getAnnotationTarget()
	 * @generated
	 */
	EReference getAnnotationTarget_Annotations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnnotationFactory getAnnotationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.annotation.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationImpl
		 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Annotation Target</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__ANNOTATION_TARGET = eINSTANCE.getAnnotation_AnnotationTarget();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.annotation.impl.AnnotationEntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationEntryImpl
		 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationPackageImpl#getAnnotationEntry()
		 * @generated
		 */
		EClass ANNOTATION_ENTRY = eINSTANCE.getAnnotationEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_ENTRY__KEY = eINSTANCE.getAnnotationEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_ENTRY__VALUE = eINSTANCE.getAnnotationEntry_Value();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_ENTRY__SOURCE = eINSTANCE.getAnnotationEntry_Source();

		/**
		 * The meta object literal for the '{@link de.thm.evolvedb.graph.annotation.impl.AnnotationTargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationTargetImpl
		 * @see de.thm.evolvedb.graph.annotation.impl.AnnotationPackageImpl#getAnnotationTarget()
		 * @generated
		 */
		EClass ANNOTATION_TARGET = eINSTANCE.getAnnotationTarget();

		/**
		 * The meta object literal for the '<em><b>Target URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_TARGET__TARGET_URI = eINSTANCE.getAnnotationTarget_TargetURI();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_TARGET__ANNOTATIONS = eINSTANCE.getAnnotationTarget_Annotations();

	}

} //AnnotationPackage
