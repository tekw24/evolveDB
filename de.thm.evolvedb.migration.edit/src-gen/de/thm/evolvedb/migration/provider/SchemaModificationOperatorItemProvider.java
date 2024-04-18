/**
 */
package de.thm.evolvedb.migration.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import de.thm.evolvedb.mdde.NamedElement;
import de.thm.evolvedb.migration.MigrationPackage;
import de.thm.evolvedb.migration.NotAutomaticallyResolvable;
import de.thm.evolvedb.migration.PartiallyResolvable;
import de.thm.evolvedb.migration.ProcessStatus;
import de.thm.evolvedb.migration.ResolvableOperator;
import de.thm.evolvedb.migration.SchemaModificationOperator;

/**
 * This is the item provider adapter for a
 * {@link de.thm.evolvedb.migration.SchemaModificationOperator} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SchemaModificationOperatorItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SchemaModificationOperatorItemProvider(AdapterFactory adapterFactory) {
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

			addSemanticChangeSetsPropertyDescriptor(object);
			addProcessStatusPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Semantic Change Sets feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSemanticChangeSetsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchemaModificationOperator_semanticChangeSets_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchemaModificationOperator_semanticChangeSets_feature", "_UI_SchemaModificationOperator_type"),
				 MigrationPackage.Literals.SCHEMA_MODIFICATION_OPERATOR__SEMANTIC_CHANGE_SETS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Process Status feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProcessStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchemaModificationOperator_processStatus_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchemaModificationOperator_processStatus_feature", "_UI_SchemaModificationOperator_type"),
				 MigrationPackage.Literals.SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SchemaModificationOperator_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SchemaModificationOperator_description_feature", "_UI_SchemaModificationOperator_type"),
				 MigrationPackage.Literals.SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {

		SchemaModificationOperator task = (SchemaModificationOperator) object;
		if (task.getProcessStatus().equals(ProcessStatus.UNRESOLVED)) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/warning16.png"));
		} else {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/check16.png"));
		}

		// return overlayImage(object,
		// getResourceLocator().getImage("full/obj16/ResolvableOperator"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		SchemaModificationOperator o = ((SchemaModificationOperator) object);
		EList<SemanticChangeSet> s = o.getSemanticChangeSets();

		SemanticChangeSet semanticChangeSet = s.get(0);
		EList<Change> changes = semanticChangeSet.getChanges();
		Change change = null;

		if (changes.size() == 1) {
			change = changes.get(0);
		} else {
			change = changes.get(0);
		}

		String prefix = "";
		if (change instanceof RemoveObject) {
			prefix = getName((RemoveObject) change);
		} else if (change instanceof AddObject) {
			prefix = getName((AddObject) change);
		} else if (change instanceof RemoveReference) {
			prefix = getName((RemoveReference) change);
		} else if (change instanceof AddReference) {
			prefix = getName((AddReference) change);
		} else if (change instanceof AttributeValueChange) {
			prefix = getName((AttributeValueChange) change);
		}
		
		
		if (o instanceof ResolvableOperator)
			return  "ResolvableOperator "  + ((ResolvableOperator) object).getDisplayName()+ " " + prefix;
		else if (o instanceof PartiallyResolvable)
			return "PartiallyResolvable " +((PartiallyResolvable) object).getDisplayName() + " " + prefix;
		else if (o instanceof NotAutomaticallyResolvable)
			return "NotAutomaticallyResolvable " + ((NotAutomaticallyResolvable) object).getDisplayName() + " " + prefix;

		

		ProcessStatus labelValue = ((SchemaModificationOperator) object).getProcessStatus();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ? getString("_UI_SchemaModificationOperator_type")
				: getString("_UI_SchemaModificationOperator_type") + " " + label;
	}

	/**
	 * @param change
	 * @return
	 * @generated NOT
	 */
	private String getName(AttributeValueChange change) {
		if (change.getObjA() instanceof NamedElement) {
			NamedElement n = (NamedElement) change.getObjA();
			return n.getName();
		}
		return "";
	}

	/**
	 * 
	 * @param removeObject
	 * @return
	 * @generated NOT
	 */
	public String getName(RemoveObject removeObject) {
		if (removeObject.getObj() instanceof NamedElement) {
			NamedElement n = (NamedElement) removeObject.getObj();
			return n.getName();
		}
		return "";
	}

	/**
	 * 
	 * @param removeObject
	 * @return
	 * @generated NOT
	 */
	public String getName(AddObject removeObject) {
		if (removeObject.getObj() instanceof NamedElement) {
			NamedElement n = (NamedElement) removeObject.getObj();
			return n.getName();
		}
		return "";
	}

	/**
	 * 
	 * @param removeObject
	 * @return
	 * @generated NOT
	 */
	public String getName(RemoveReference removeObject) {
		if (removeObject.getSrc() != null && removeObject.getSrc() instanceof NamedElement) {
			NamedElement n = (NamedElement) removeObject.getSrc();
			return n.getName();
		} else if (removeObject.getTgt() != null && removeObject.getTgt() instanceof NamedElement) {
			NamedElement n = (NamedElement) removeObject.getTgt();
			return n.getName();
		}
		return "";
	}

	/**
	 * 
	 * @param removeObject
	 * @return
	 * @generated NOT
	 */
	public String getName(AddReference removeObject) {
		if (removeObject.getSrc() instanceof NamedElement) {
			NamedElement n = (NamedElement) removeObject.getSrc();
			return n.getName();
		}
		return "";
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

		switch (notification.getFeatureID(SchemaModificationOperator.class)) {
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__PROCESS_STATUS:
			case MigrationPackage.SCHEMA_MODIFICATION_OPERATOR__DESCRIPTION:
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

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MigrationEditPlugin.INSTANCE;
	}

}
