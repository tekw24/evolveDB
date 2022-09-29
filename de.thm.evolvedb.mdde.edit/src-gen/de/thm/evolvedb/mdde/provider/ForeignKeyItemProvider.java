/**
 */
package de.thm.evolvedb.mdde.provider;

import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddePackage;
import de.thm.evolvedb.mdde.PrimaryKey;
import de.thm.evolvedb.mdde.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.thm.evolvedb.mdde.ForeignKey} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ForeignKeyItemProvider extends ColumnItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ForeignKeyItemProvider(AdapterFactory adapterFactory) {
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

			addReferencedTablePropertyDescriptor(object);
			addPrimaryForeignKeyPropertyDescriptor(object);
			addOnUpdatePropertyDescriptor(object);
			addOnDeletePropertyDescriptor(object);
			addConstraintNamePropertyDescriptor(object);
			addReferencedKeyColumnPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Referenced Table feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addReferencedTablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForeignKey_referencedTable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForeignKey_referencedTable_feature", "_UI_ForeignKey_type"),
				 MddePackage.Literals.FOREIGN_KEY__REFERENCED_TABLE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Foreign Key feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPrimaryForeignKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForeignKey_primaryForeignKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForeignKey_primaryForeignKey_feature", "_UI_ForeignKey_type"),
				 MddePackage.Literals.FOREIGN_KEY__PRIMARY_FOREIGN_KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the On Update feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addOnUpdatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForeignKey_OnUpdate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForeignKey_OnUpdate_feature", "_UI_ForeignKey_type"),
				 MddePackage.Literals.FOREIGN_KEY__ON_UPDATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the On Delete feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addOnDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForeignKey_OnDelete_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForeignKey_OnDelete_feature", "_UI_ForeignKey_type"),
				 MddePackage.Literals.FOREIGN_KEY__ON_DELETE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Constraint Name feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addConstraintNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForeignKey_constraintName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForeignKey_constraintName_feature", "_UI_ForeignKey_type"),
				 MddePackage.Literals.FOREIGN_KEY__CONSTRAINT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Referenced Key Column feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addReferencedKeyColumnPropertyDescriptor(Object object) {
		//		itemPropertyDescriptors
		//				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
		//						getResourceLocator(), getString("_UI_ForeignKey_referencedKeyColumn_feature"),
		//						getString("_UI_PropertyDescriptor_description", "_UI_ForeignKey_referencedKeyColumn_feature",
		//								"_UI_ForeignKey_type"),
		//						MddePackage.Literals.FOREIGN_KEY__REFERENCED_KEY_COLUMN, true, false, true, null, null, null));
		//Explained in Steinberg 395
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ForeignKey_referencedKeyColumn_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ForeignKey_referencedKeyColumn_feature",
								"_UI_ForeignKey_type"),
						MddePackage.Literals.FOREIGN_KEY__REFERENCED_KEY_COLUMN, true, false, true, null, null, null) {
					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						ForeignKey foreignKey = (ForeignKey) object;
						List<PrimaryKey> resList = new ArrayList<PrimaryKey>();

						if (foreignKey.getReferencedTable() != null) {
							Table table = foreignKey.getReferencedTable();
							resList.addAll(table.getPrimaryKeys());
						}

						return resList;
					}

				});
	}

	/**
	 * This returns ForeignKey.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		ForeignKey key = (ForeignKey) object;
		if (key.getPrimaryForeignKey() != null && key.getPrimaryForeignKey())
			return overlayImage(object, getResourceLocator().getImage("full/obj16/foreignKeyGreen16.png"));
		else
			return overlayImage(object, getResourceLocator().getImage("full/obj16/foreignKey16.png"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ForeignKey)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ForeignKey_type") :
			getString("_UI_ForeignKey_type") + " " + label;
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

		switch (notification.getFeatureID(ForeignKey.class)) {
			case MddePackage.FOREIGN_KEY__PRIMARY_FOREIGN_KEY:
			case MddePackage.FOREIGN_KEY__ON_UPDATE:
			case MddePackage.FOREIGN_KEY__ON_DELETE:
			case MddePackage.FOREIGN_KEY__CONSTRAINT_NAME:
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
