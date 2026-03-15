/**
 */
package de.thm.evolvedb.graph.annotation.impl;

import de.thm.evolvedb.graph.annotation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnnotationFactoryImpl extends EFactoryImpl implements AnnotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationFactory init() {
		try {
			AnnotationFactory theAnnotationFactory = (AnnotationFactory) EPackage.Registry.INSTANCE
					.getEFactory(AnnotationPackage.eNS_URI);
			if (theAnnotationFactory != null) {
				return theAnnotationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnnotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AnnotationPackage.ANNOTATION:
			return createAnnotation();
		case AnnotationPackage.ANNOTATION_ENTRY:
			return createAnnotationEntry();
		case AnnotationPackage.ANNOTATION_TARGET:
			return createAnnotationTarget();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotationEntry createAnnotationEntry() {
		AnnotationEntryImpl annotationEntry = new AnnotationEntryImpl();
		return annotationEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotationTarget createAnnotationTarget() {
		AnnotationTargetImpl annotationTarget = new AnnotationTargetImpl();
		return annotationTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotationPackage getAnnotationPackage() {
		return (AnnotationPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnnotationPackage getPackage() {
		return AnnotationPackage.eINSTANCE;
	}

} //AnnotationFactoryImpl
