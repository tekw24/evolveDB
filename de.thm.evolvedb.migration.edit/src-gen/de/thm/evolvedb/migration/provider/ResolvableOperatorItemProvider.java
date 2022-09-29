/**
 */
package de.thm.evolvedb.migration.provider;

import java.util.Collection;
import java.util.List;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.evolvedb.migration.ResolvableOperatorType;

/**
 * This is the item provider adapter for a {@link de.thm.evolvedb.migration.ResolvableOperator} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ResolvableOperatorItemProvider extends SchemaModificationOperatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ResolvableOperatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDisplayNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Display Name feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDisplayNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResolvableOperator_displayName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResolvableOperator_displayName_feature", "_UI_ResolvableOperator_type"),
				 MigrationPackage.Literals.RESOLVABLE_OPERATOR__DISPLAY_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns ResolvableOperator.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
//		ResolvableOperator task = (ResolvableOperator) object;
//		if (task.getProcessStatus().equals(ProcessStatus.UNRESOLVED)) {
//			return overlayImage(object, getResourceLocator().getImage("full/obj16/warning16.png"));
//		} else {
//			return overlayImage(object, getResourceLocator().getImage("full/obj16/ResolvableOperator"));
//		}

		// return overlayImage(object,
		// getResourceLocator().getImage("full/obj16/ResolvableOperator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		ResolvableOperatorType labelValue = ((ResolvableOperator)object).getDisplayName();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_ResolvableOperator_type") :
			getString("_UI_ResolvableOperator_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ResolvableOperator.class)) {
			case MigrationPackage.RESOLVABLE_OPERATOR__DISPLAY_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
