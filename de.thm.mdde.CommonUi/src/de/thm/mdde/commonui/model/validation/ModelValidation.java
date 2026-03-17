/*
 * EvolveDB - Model Driven Schema Evolution
 * Copyright Technische Hochschule Mittelhessen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.thm.mdde.commonui.model.validation;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import de.thm.commonui.util.ResourceUtil;
import de.thm.evolvedb.graph.annotation.AnnotationAdapter;
import de.thm.mdde.commonui.exception.handler.ErrorHandler;

public class ModelValidation {

	public static boolean validateModel(ResourceSet resourceSet, String pluginID) {

		for (Resource r : resourceSet.getResources()) {

			// Validate the file
			IFile file = ResourceUtil.getFile(r);
			return validateModel(r, pluginID, file);
		}

		return false;

	}

	public static boolean validateModel(Resource resource, String pluginID, IFile file) {
		return validateModel(resource, pluginID, file, true);
	}

//	public static boolean validateModel(Resource resource, String pluginID, IFile file, boolean showResult) {
//		EObject root = resource.getContents().get(0);
//		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(root);
//		if (file != null) {
//
//			try {
//				file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ZERO);
//			} catch (CoreException e) {
//				ErrorHandler.openErrorDialogWithStatus(pluginID, "An exception occured",
//						Display.getCurrent().getActiveShell(), "Error", e);
//				e.printStackTrace();
//			}
//			
//			TreeIterator<EObject> it = root.eAllContents();
//			while (it.hasNext()) {
//			    EObject obj = it.next();
//
//			    AnnotationAdapter adapter =
//			        (AnnotationAdapter) EcoreUtil.getAdapter(obj.eAdapters(), AnnotationAdapter.class);
//
//			    if (adapter != null && adapter.getAnnotations() != null && !adapter.getAnnotations().isEmpty()) {
//			   		    	
//			    	diagnostic.getChildren().add(
//			            new BasicDiagnostic(
//			                Diagnostic.WARNING,
//			                "de.thm.evolvedb.graph.validation",
//			                0,
//			                "Element has annotations.",
//			                new Object[] { obj }
//			            )
//			        );
//			    }
//			}
//			
//
//			// Iterate over the list and create markers add the file
//			for (Diagnostic d : diagnostic.getChildren()) {
//
//				IMarker marker = null;
//				try {
//					switch (d.getSeverity()) {
//					case Diagnostic.ERROR:
//						marker = file.createMarker(EValidator.MARKER);
//						marker.setAttribute(IMarker.MESSAGE, d.getMessage());
//						marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
//						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
//
//						break;
//					case Diagnostic.INFO:
//						marker = file.createMarker(EValidator.MARKER);
//						marker.setAttribute(IMarker.MESSAGE, d.getMessage());
//						marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_LOW);
//						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
//						break;
//
//					case Diagnostic.WARNING:
//						marker = file.createMarker(EValidator.MARKER);
//						marker.setAttribute(IMarker.MESSAGE, d.getMessage());
//						marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
//						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
//						break;
//
//					default:
//						marker = file.createMarker(EValidator.MARKER);
//						marker.setAttribute(IMarker.MESSAGE, d.getMessage());
//						marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
//						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
//						break;
//					}
//
//					// The data should be an EObject
//					if (d.getData() != null && d.getData().size() > 0) {
//						Object object = d.getData().get(0);
//
//						String path = EcoreUtil.getURI((EObject) object).toString();
//						String path2 = EcoreUtil.getURI((EObject) object).toFileString();
//						String path3 = EcoreUtil.getURI((EObject) object).toPlatformString(false);
//						String path4 = EcoreUtil.getURI((EObject) object).toPlatformString(true);
//
//						if (object instanceof EObject) {
//							marker.setAttribute(EValidator.URI_ATTRIBUTE,
//									EcoreUtil.getURI((EObject) object).toString());
//						}
//					}
//
//				} catch (CoreException e) {
//
//					ErrorHandler.openErrorDialogWithStatus(pluginID, "An exception occured",
//							Display.getCurrent().getActiveShell(), "Error", e);
//					e.printStackTrace();
//				}
//
//			}
//			// Give user feedback
//			if (diagnostic != null) {
//				boolean result = true;
//				switch (diagnostic.getSeverity()) {
//				case Diagnostic.ERROR:
//					if (showResult)
//						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error",
//								"The validation finished with errors!");
//					result = false;
//					break;
//				case Diagnostic.INFO:
//					if (showResult)
//						MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Info",
//								diagnostic.getMessage());
//					result = true;
//					break;
//
//				case Diagnostic.WARNING:
//					if (showResult)
//						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Warning",
//								"The validation finished with warnings!");
//					result = true;
//					break;
//				case Diagnostic.OK:
//					if (showResult)
//						MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Validation",
//								"Validation successfull!");
//					result = true;
//					break;
//
//				default:
//					break;
//				}
//				return result;
//			}
//
//		}
//
//		return true;
//	}
	
	public static boolean validateModel(Resource resource, String pluginID, IFile file, boolean showResult) {
	    if (resource == null || resource.getContents().isEmpty()) {
	        return true;
	    }

	    final EObject root = resource.getContents().get(0);

	    final BasicDiagnostic diagnostic = new BasicDiagnostic();
	    Diagnostician.INSTANCE.validate(root, diagnostic, new HashMap<>());

	    addAnnotationWarning(root, diagnostic);

	    final TreeIterator<EObject> it = root.eAllContents();
	    while (it.hasNext()) {
	        addAnnotationWarning(it.next(), diagnostic);
	    }

	    if (file != null) {
	        try {
	            file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ZERO);
	        } catch (CoreException e) {
	            ErrorHandler.openErrorDialogWithStatus(
	                pluginID,
	                "An exception occured",
	                Display.getCurrent().getActiveShell(),
	                "Error",
	                e
	            );
	            e.printStackTrace();
	        }

	        for (Diagnostic d : diagnostic.getChildren()) {
	            try {
	                final IMarker marker = file.createMarker(EValidator.MARKER);

	                marker.setAttribute(IMarker.MESSAGE, d.getMessage());

	                switch (d.getSeverity()) {
	                case Diagnostic.ERROR:
	                    marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
	                    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
	                    break;
	                case Diagnostic.INFO:
	                    marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_LOW);
	                    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
	                    break;
	                case Diagnostic.WARNING:
	                    marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
	                    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
	                    break;
	                default:
	                    marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
	                    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
	                    break;
	                }

	                if (d.getData() != null && !d.getData().isEmpty() && d.getData().get(0) instanceof EObject eObject) {
	                    marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(eObject).toString());
	                }

	            } catch (CoreException e) {
	                ErrorHandler.openErrorDialogWithStatus(
	                    pluginID,
	                    "An exception occured",
	                    Display.getCurrent().getActiveShell(),
	                    "Error",
	                    e
	                );
	                e.printStackTrace();
	            }
	        }
	    }

	    if (showResult) {
	        switch (diagnostic.getSeverity()) {
	        case Diagnostic.ERROR:
	            MessageDialog.openError(
	                Display.getCurrent().getActiveShell(),
	                "Error",
	                "The validation finished with errors!"
	            );
	            return false;
	        case Diagnostic.WARNING:
	            MessageDialog.openWarning(
	                Display.getCurrent().getActiveShell(),
	                "Warning",
	                "The validation finished with warnings!"
	            );
	            return true;
	        case Diagnostic.INFO:
	            MessageDialog.openInformation(
	                Display.getCurrent().getActiveShell(),
	                "Info",
	                diagnostic.getMessage()
	            );
	            return true;
	        case Diagnostic.OK:
	            MessageDialog.openInformation(
	                Display.getCurrent().getActiveShell(),
	                "Validation",
	                "Validation successful!"
	            );
	            return true;
	        default:
	            return true;
	        }
	    }

	    return diagnostic.getSeverity() != Diagnostic.ERROR;
	}

	private static void addAnnotationWarning(EObject obj, BasicDiagnostic diagnostic) {
	    final AnnotationAdapter adapter =
	        (AnnotationAdapter) EcoreUtil.getAdapter(obj.eAdapters(), AnnotationAdapter.class);

	    if (adapter != null && adapter.getAnnotations() != null && !adapter.getAnnotations().isEmpty()) {
	        diagnostic.add(new BasicDiagnostic(
	            Diagnostic.WARNING,
	            "de.thm.evolvedb.graph.validation",
	            0,
	            "Element has annotations.",
	            new Object[] { obj }
	        ));
	    }
	}

}
