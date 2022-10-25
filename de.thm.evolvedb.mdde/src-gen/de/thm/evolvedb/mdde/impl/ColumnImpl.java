/**
 */
package de.thm.evolvedb.mdde.impl;

import de.thm.evolvedb.mdde.Column;
import de.thm.evolvedb.mdde.DataType;
import de.thm.evolvedb.mdde.ForeignKey;
import de.thm.evolvedb.mdde.MddePackage;

import de.thm.evolvedb.mdde.Table;
import de.thm.evolvedb.mdde.util.MddeValidator;
import java.lang.reflect.InvocationTargetException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Column</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getTable <em>Table</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getNotNull <em>Not Null</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getUnique <em>Unique</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getAutoIncrement <em>Auto Increment</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getSize <em>Size</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.thm.evolvedb.mdde.impl.ColumnImpl#getUniqueConstraintName <em>Unique Constraint Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColumnImpl extends NamedElementImpl implements Column {
	/**
	 * @generated NOT
	 */
	public static List<DataType> textTypes = Arrays.asList(DataType.CHAR, DataType.VARCHAR, DataType.TINYTEXT);

	/**
	 * @generated NOT
	 */
	public static List<DataType> binaryTypes = Arrays.asList(DataType.BINARY, DataType.VARBINARY, DataType.BLOB,
			DataType.BIT);

	/**
	 * @generated NOT
	 */
	public static List<DataType> dateTypesWithFraction = Arrays.asList(DataType.DATETIME, DataType.TIMESTAMP,
			DataType.TIME);

	/**
	 * @generated NOT
	 */
	public static List<DataType> decimalTypes = Arrays.asList(DataType.DEC, DataType.DECIMAL, DataType.FLOAT);

	/**
	 * @generated NOT
	 */
	public static List<DataType> typesWithoutSize = Arrays.asList(DataType.TINYBLOB, DataType.TINYTEXT,
			DataType.MEDIUMBLOB, DataType.MEDIUMTEXT, DataType.LONGBLOB, DataType.LONGTEXT, DataType.BINARY,
			DataType.VARBINARY, DataType.BOOL, DataType.BOOLEAN, DataType.DATE, DataType.YEAR);
	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getNotNull() <em>Not Null</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNotNull()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean NOT_NULL_EDEFAULT = Boolean.FALSE;
	/**
	 * The cached value of the '{@link #getNotNull() <em>Not Null</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNotNull()
	 * @generated
	 * @ordered
	 */
	protected Boolean notNull = NOT_NULL_EDEFAULT;
	/**
	 * The default value of the '{@link #getUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUnique()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean UNIQUE_EDEFAULT = Boolean.FALSE;
	/**
	 * The cached value of the '{@link #getUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUnique()
	 * @generated
	 * @ordered
	 */
	protected Boolean unique = UNIQUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getAutoIncrement() <em>Auto Increment</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAutoIncrement()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean AUTO_INCREMENT_EDEFAULT = Boolean.FALSE;
	/**
	 * The cached value of the '{@link #getAutoIncrement() <em>Auto Increment</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAutoIncrement()
	 * @generated
	 * @ordered
	 */
	protected Boolean autoIncrement = AUTO_INCREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final String SIZE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected String size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DataType TYPE_EDEFAULT = DataType.CHAR;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DataType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUniqueConstraintName() <em>Unique Constraint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueConstraintName()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIQUE_CONSTRAINT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUniqueConstraintName() <em>Unique Constraint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueConstraintName()
	 * @generated
	 * @ordered
	 */
	protected String uniqueConstraintName = UNIQUE_CONSTRAINT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MddePackage.Literals.COLUMN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getTable() {
		if (eContainerFeatureID() != MddePackage.COLUMN__TABLE) return null;
		return (Table)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTable(Table newTable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTable, MddePackage.COLUMN__TABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTable(Table newTable) {
		if (newTable != eInternalContainer() || (eContainerFeatureID() != MddePackage.COLUMN__TABLE && newTable != null)) {
			if (EcoreUtil.isAncestor(this, newTable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTable != null)
				msgs = ((InternalEObject)newTable).eInverseAdd(this, MddePackage.TABLE__COLUMNS, Table.class, msgs);
			msgs = basicSetTable(newTable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__TABLE, newTable, newTable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getNotNull() {
		return notNull;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNotNull(Boolean newNotNull) {
		Boolean oldNotNull = notNull;
		notNull = newNotNull;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__NOT_NULL, oldNotNull, notNull));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getUnique() {
		return unique;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnique(Boolean newUnique) {
		Boolean oldUnique = unique;
		unique = newUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__UNIQUE, oldUnique, unique));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getAutoIncrement() {
		return autoIncrement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAutoIncrement(Boolean newAutoIncrement) {
		Boolean oldAutoIncrement = autoIncrement;
		autoIncrement = newAutoIncrement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__AUTO_INCREMENT, oldAutoIncrement, autoIncrement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(String newSize) {
		String oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(DataType newType) {
		DataType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUniqueConstraintName() {
		return uniqueConstraintName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUniqueConstraintName(String newUniqueConstraintName) {
		String oldUniqueConstraintName = uniqueConstraintName;
		uniqueConstraintName = newUniqueConstraintName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MddePackage.COLUMN__UNIQUE_CONSTRAINT_NAME, oldUniqueConstraintName, uniqueConstraintName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean validateDefaultValue(DiagnosticChain chain, Map<Object, Object> emap) {
		if (getDefaultValue() != null) {

			boolean returnValue = true;
			String defaultValue = getDefaultValue();

			int size = 0;

			if (textTypes.contains(getType()) || dateTypesWithFraction.contains(getType())) {
				if (getSize() != null)
					size = Integer.valueOf(getSize());

				if (dateTypesWithFraction.contains(getType())) {
					String dateformat = "YYYY-MM-DD hh:mm:ss";
					if (getType().equals(DataType.TIME))
						dateformat = "hh:mm:ss";
					// Check the size attribute
					if (size > 0) {
						// Default value is validated before size attribute
						size = size > 6 ? 6 : size;

						dateformat += ".";
						for (int i = 1; i <= size; i++) {
							dateformat += "S";
						}

					}

					SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
					ParsePosition position = new ParsePosition(0);
					Date result = sdf.parse(defaultValue, position);

					if (position.getIndex() == 0) {

						if (chain != null) {
							chain.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
									MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
									"Incompatible Default Value. The default value is not convertible into a DateTime or Timestamp! The default value for should have this \'"
											+ dateformat + "\' format.",
									new Object[] { this }));
						}

						returnValue = false;
					}

				}

				if (textTypes.contains(getType())) {

					switch (getType()) {
					case VARCHAR:
						if (size < getDefaultValue().length() - 1)
							if (chain != null) {
								chain.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
										MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
										"Invalid size of Default Value. The default value can not be longer than the column size!",
										new Object[] { this }));
							}

						returnValue = false;

						break;

					case CHAR:
						if (size < getDefaultValue().length() - 1)
							if (chain != null) {
								chain.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
										MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
										"Invalid size of Default Value. The default value can not be longer than the column size!",
										new Object[] { this }));
							}

						returnValue = false;

						break;
					case TINYTEXT:
						if (getDefaultValue().length() > 255)
							if (chain != null) {
								chain.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
										MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
										"Invalid size of Default Value. The default value can not be longer than the column size!",
										new Object[] { this }));
							}

						returnValue = false;

						break;

					default:
						break;
					}

				}

			}

			// If the type is numeric, only digits are allowed.
			List<DataType> numericTypes = Arrays.asList(DataType.BIGINT, DataType.DOUBLE, DataType.DECIMAL,
					DataType.DEC, DataType.FLOAT, DataType.INTEGER, DataType.MEDIUMINT, DataType.SMALLINT,
					DataType.TINYINT, DataType.BIGINT);

			if (numericTypes.contains(getType())) {

				if (getType().equals(DataType.DECIMAL) || getType().equals(DataType.DEC)) {
					if (!(defaultValue.matches("[0-9]+") || defaultValue.matches("[0-9]+\\.[0-9]+"))) {

						if (chain != null) {
							chain.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
									MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
									"Incompatible Default Value. The default value is not compatible with the column type!",
									new Object[] { this }));
						}

						returnValue = false;
					}

				} else if (!defaultValue.matches("[0-9]+")) {

					if (chain != null) {
						chain.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
								MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
								"Incompatible Default Value. The default value is not compatible with the column type!",
								new Object[] { this }));
					}

					returnValue = false;
				}

			}

			if (getType().equals(DataType.DATE)) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				ParsePosition position = new ParsePosition(0);
				Date result = sdf.parse(defaultValue, position);

				if (position.getIndex() == 0) {

					if (chain != null) {
						chain.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
								MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
								"Incompatible Default Value. The default value is not convertible into a Date! The default value for the Date type should have this \'yyyy-MM-dd format\'.",
								new Object[] { this }));
					}

					returnValue = false;
				}

			}

			return returnValue;

		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean validateSizeValue(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean returnValue = true;
		if (getSize() != null) {
			if (typesWithoutSize.contains(getType())) {
				int size = Integer.valueOf(getSize());
				if (size > 0)
					if (diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, MddeValidator.DIAGNOSTIC_SOURCE,
								MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
								"The selected data type does not support a size or display witdh value.",
								new Object[] { this }));
					}

				returnValue = false;

			} else if (dateTypesWithFraction.contains(getType())) {
				int size = Integer.valueOf(getSize());
				if (size > 6)
					if (diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
								MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
								"Invalid value for size. The optional fsp value should be in the range from 0 to 6 to specify fractional seconds precision. A value of 0 signifies that there is no fractional part.",
								new Object[] { this }));
					}

				returnValue = false;
			} else if (decimalTypes.contains(getType())) {

				switch (getType()) {
				case DECIMAL:
				case DEC:
					if (getSize().matches("[0-9]+")) {
						if (Integer.valueOf(getSize()) <= 65)
							break;
						else {
							if (diagnostics != null) {
								diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
										MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
										"The maximum number of digits (M) for DECIMAL is 65. The maximum number of supported decimals (D) is 30.",
										new Object[] { this }));
							}
							returnValue = false;
						}
					}

					if (getSize().matches("[0-9]+\\.[0-9]+")) {
						String[] size = getSize().split("\\.");
						if (size.length == 2) {
							if (Integer.valueOf(size[0]) <= 65 && Integer.valueOf(size[1]) <= 30)
								break;
							else {
								if (diagnostics != null) {
									diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
											MddeValidator.DIAGNOSTIC_SOURCE,
											MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
											"The maximum number of digits (M) for DECIMAL is 65. The maximum number of supported decimals (D) is 30.",
											new Object[] { this }));
								}
								returnValue = false;
							}
						} else {
							if (diagnostics != null) {
								diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
										MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
										"Size should have the following pattern: 'M.D'. M is the maximum number of digits and D the number of supported decimals.",
										new Object[] { this }));
							}
							returnValue = false;
						}
					}
					break;
				case FLOAT:

					if (getSize().matches("[0-9]+")) {
						int size = Integer.valueOf(getSize());
						if (size > 53) {
							if (diagnostics != null) {
								diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
										MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
										"Invalid value for size. The size value for float should be in the range from 0 to 53!",
										new Object[] { this }));
							}
							returnValue = false;
						}

					}

					break;
				default:
					break;
				}

			} else if (textTypes.contains(getType())) {
				int size = Integer.valueOf(getSize());
				switch (getType()) {
				case VARCHAR:
					if (size > 65535) {
						if (diagnostics != null) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
									MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
									"Invalid value for size. The size value for VARCHAR should be in the range from 0 to 65535!",
									new Object[] { this }));
						}
						returnValue = false;
					} else if (size > 21844) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, MddeValidator.DIAGNOSTIC_SOURCE,
								MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
								"Utf8 characters can require up to three bytes per character, so a VARCHAR column that uses the utf8 character set can be declared to be a maximum of 21,844 characters.",
								new Object[] { this }));
						returnValue = false;
					}

					break;
				case CHAR:
					if (size > 255) {
						if (diagnostics != null) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
									MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
									"Invalid value for size. The size value for CHAR should be in the range from 0 to 255!",
									new Object[] { this }));
						}
						returnValue = false;
					}
					break;

				}
			} else if (binaryTypes.contains(getType())) {
				int size = Integer.valueOf(getSize());
				switch (getType()) {
				case VARBINARY:
					if (size > 65535) {
						if (diagnostics != null) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
									MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
									"Invalid value for size. The size value for VARBINARY should be in the range from 0 to 65535!",
									new Object[] { this }));
						}
						returnValue = false;
					}
					break;
				case BINARY:
					if (size > 255) {
						if (diagnostics != null) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
									MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
									"Invalid value for size. The size value for BINARY should be in the range from 0 to 255!",
									new Object[] { this }));
						}
						returnValue = false;
					}
					break;
				case BIT:
					if (size > 64 || size < 1) {
						if (diagnostics != null) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
									MddeValidator.COLUMN__VALIDATE_DEFAULT_VALUE,
									"Invalid value for size. The size value for VARBINARY should be in the range from 1 to 64!",
									new Object[] { this }));
						}
						returnValue = false;
					}
					break;
				}

			}

		}
		return returnValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateUniqueConstraintName(DiagnosticChain diagnostics, Map<Object, Object> context) {
	
		if (getUniqueConstraintName() != null && !getUniqueConstraintName().equals("")) {

			EList<Column> columns = getTable().getColumns();
			List<String> constraintNames = new ArrayList<>();
			for(Column column : columns) {
				if(column.equals(this))
					continue;
				if(column.getUnique() && column.getUniqueConstraintName() != null && !column.getUniqueConstraintName().equals(""))
					constraintNames.add(column.getUniqueConstraintName());
			}
				
			if (constraintNames.contains(getUniqueConstraintName())) {

				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MddeValidator.DIAGNOSTIC_SOURCE,
						MddeValidator.COLUMN__VALIDATE_UNIQUE_CONSTRAINT_NAME,
						"Invalid constraint name. The unique constraint name has to be unique!", new Object[] { this }));
				return false;
			}
		}

		return true;
		
		
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MddePackage.COLUMN__TABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTable((Table)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MddePackage.COLUMN__TABLE:
				return basicSetTable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MddePackage.COLUMN__TABLE:
				return eInternalContainer().eInverseRemove(this, MddePackage.TABLE__COLUMNS, Table.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MddePackage.COLUMN__TABLE:
				return getTable();
			case MddePackage.COLUMN__DEFAULT_VALUE:
				return getDefaultValue();
			case MddePackage.COLUMN__NOT_NULL:
				return getNotNull();
			case MddePackage.COLUMN__UNIQUE:
				return getUnique();
			case MddePackage.COLUMN__AUTO_INCREMENT:
				return getAutoIncrement();
			case MddePackage.COLUMN__SIZE:
				return getSize();
			case MddePackage.COLUMN__TYPE:
				return getType();
			case MddePackage.COLUMN__UNIQUE_CONSTRAINT_NAME:
				return getUniqueConstraintName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MddePackage.COLUMN__TABLE:
				setTable((Table)newValue);
				return;
			case MddePackage.COLUMN__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case MddePackage.COLUMN__NOT_NULL:
				setNotNull((Boolean)newValue);
				return;
			case MddePackage.COLUMN__UNIQUE:
				setUnique((Boolean)newValue);
				return;
			case MddePackage.COLUMN__AUTO_INCREMENT:
				setAutoIncrement((Boolean)newValue);
				return;
			case MddePackage.COLUMN__SIZE:
				setSize((String)newValue);
				return;
			case MddePackage.COLUMN__TYPE:
				setType((DataType)newValue);
				return;
			case MddePackage.COLUMN__UNIQUE_CONSTRAINT_NAME:
				setUniqueConstraintName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MddePackage.COLUMN__TABLE:
				setTable((Table)null);
				return;
			case MddePackage.COLUMN__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case MddePackage.COLUMN__NOT_NULL:
				setNotNull(NOT_NULL_EDEFAULT);
				return;
			case MddePackage.COLUMN__UNIQUE:
				setUnique(UNIQUE_EDEFAULT);
				return;
			case MddePackage.COLUMN__AUTO_INCREMENT:
				setAutoIncrement(AUTO_INCREMENT_EDEFAULT);
				return;
			case MddePackage.COLUMN__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case MddePackage.COLUMN__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MddePackage.COLUMN__UNIQUE_CONSTRAINT_NAME:
				setUniqueConstraintName(UNIQUE_CONSTRAINT_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MddePackage.COLUMN__TABLE:
				return getTable() != null;
			case MddePackage.COLUMN__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case MddePackage.COLUMN__NOT_NULL:
				return NOT_NULL_EDEFAULT == null ? notNull != null : !NOT_NULL_EDEFAULT.equals(notNull);
			case MddePackage.COLUMN__UNIQUE:
				return UNIQUE_EDEFAULT == null ? unique != null : !UNIQUE_EDEFAULT.equals(unique);
			case MddePackage.COLUMN__AUTO_INCREMENT:
				return AUTO_INCREMENT_EDEFAULT == null ? autoIncrement != null : !AUTO_INCREMENT_EDEFAULT.equals(autoIncrement);
			case MddePackage.COLUMN__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case MddePackage.COLUMN__TYPE:
				return type != TYPE_EDEFAULT;
			case MddePackage.COLUMN__UNIQUE_CONSTRAINT_NAME:
				return UNIQUE_CONSTRAINT_NAME_EDEFAULT == null ? uniqueConstraintName != null : !UNIQUE_CONSTRAINT_NAME_EDEFAULT.equals(uniqueConstraintName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MddePackage.COLUMN___VALIDATE_DEFAULT_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateDefaultValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MddePackage.COLUMN___VALIDATE_SIZE_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateSizeValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MddePackage.COLUMN___VALIDATE_UNIQUE_CONSTRAINT_NAME__DIAGNOSTICCHAIN_MAP:
				return validateUniqueConstraintName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (defaultValue: ");
		result.append(defaultValue);
		result.append(", notNull: ");
		result.append(notNull);
		result.append(", unique: ");
		result.append(unique);
		result.append(", autoIncrement: ");
		result.append(autoIncrement);
		result.append(", size: ");
		result.append(size);
		result.append(", type: ");
		result.append(type);
		result.append(", uniqueConstraintName: ");
		result.append(uniqueConstraintName);
		result.append(')');
		return result.toString();
	}

} // ColumnImpl
