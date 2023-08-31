/**
 */
package de.thm.evolvedb.mdde.provider;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.impl.ColumnImpl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.thm.evolvedb.mdde.Column} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ColumnItemProvider extends NamedElementItemProvider {

	private ItemPropertyDescriptor sizePropertyDescriptor;

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ColumnItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDefaultValuePropertyDescriptor(object);
			addNotNullPropertyDescriptor(object);
			addAutoIncrementPropertyDescriptor(object);
			addSizePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addConstraintsPropertyDescriptor(object);
			
		} else if (sizePropertyDescriptor != null) {
			itemPropertyDescriptors.remove(sizePropertyDescriptor);
			addSizePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Default Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDefaultValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_defaultValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_defaultValue_feature", "_UI_Column_type"),
				 MddePackage.Literals.COLUMN__DEFAULT_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Not Null feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotNullPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_notNull_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_notNull_feature", "_UI_Column_type"),
				 MddePackage.Literals.COLUMN__NOT_NULL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Auto Increment feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAutoIncrementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_autoIncrement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_autoIncrement_feature", "_UI_Column_type"),
				 MddePackage.Literals.COLUMN__AUTO_INCREMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Size feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addSizePropertyDescriptor(Object object) {
		//		itemPropertyDescriptors
		//				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
		//						getResourceLocator(), getString("_UI_Column_size_feature"),
		//						getString("_UI_PropertyDescriptor_description", "_UI_Column_size_feature", "_UI_Column_type"),
		//						MddePackage.Literals.COLUMN__SIZE, true, false, false,
		//						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));

		if (object instanceof Column) {
			Column column = (Column) object;
			boolean isSettable = true;
			String displayName = getString("_UI_Column_size_feature");
			if (ColumnImpl.dateTypesWithFraction.contains(column.getType())) {
				displayName = "Fractional seconds";
			} else if (ColumnImpl.typesWithoutSize.contains(column.getType())) {
				displayName = getString("_UI_Column_size_feature");
				isSettable = false;
			} else if (ColumnImpl.decimalTypes.contains(column.getType())) {
				displayName = "digits (M.D)";
			}
			itemPropertyDescriptors.add(
					createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
							getResourceLocator(), displayName,
							getString("_UI_PropertyDescriptor_description", "_UI_Column_size_feature",
									"_UI_Column_type"),
							MddePackage.Literals.COLUMN__SIZE, isSettable, false, false,
							ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
		} else
			itemPropertyDescriptors.add(
					createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
							getResourceLocator(), getString("_UI_Column_size_feature"),
							getString("_UI_PropertyDescriptor_description", "_UI_Column_size_feature",
									"_UI_Column_type"),
							MddePackage.Literals.COLUMN__SIZE, true, false, false,
							ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_type_feature", "_UI_Column_type"),
				 MddePackage.Literals.COLUMN__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Constraints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstraintsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_constraints_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_constraints_feature", "_UI_Column_type"),
				 MddePackage.Literals.COLUMN__CONSTRAINTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns column16.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/column16.png"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((Column) object).getName();
		//		return label == null || label.length() == 0 ? getString("_UI_Column_type")
		//				: getString("_UI_Column_type") + " " + label;

		return label == null || label.length() == 0 ? getString("_UI_Column_type") : label;
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

		switch (notification.getFeatureID(Column.class)) {
			case MddePackage.COLUMN__DEFAULT_VALUE:
			case MddePackage.COLUMN__NOT_NULL:
			case MddePackage.COLUMN__AUTO_INCREMENT:
			case MddePackage.COLUMN__SIZE:
			case MddePackage.COLUMN__TYPE:
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
