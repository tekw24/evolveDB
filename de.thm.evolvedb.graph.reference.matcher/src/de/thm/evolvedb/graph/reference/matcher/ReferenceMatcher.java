package de.thm.evolvedb.graph.reference.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.BaseMatcher;

public class ReferenceMatcher extends BaseMatcher {

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(GENERIC_TYPE);
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}

	@Override
	public String getName() {
		return "Reference Matcher";
	}

	@Override
	protected void match() {
		List<Resource> models = getModels();
		matchEdgeTypes2(models);
		matchNodeTypes(models);

	}

	private void matchNodeTypes(List<Resource> models) {
		Assert.isTrue(models.size() == 2, "Only 2 models are supported");
		
		List<EObject> eobjects = new ArrayList<EObject>();

		List<EObject> modelAContents = getAllContents(models.get(0));
		List<EObject> modelBContents = getAllContents(models.get(1));

		List<EObject> nodeTypesA = modelAContents.stream().filter(e -> e.eClass().getName().equals("NodeType"))
				.collect(Collectors.toList());

		List<EObject> nodeTypesB = modelBContents.stream().filter(e -> e.eClass().getName().equals("NodeType"))
				.collect(Collectors.toList());

		Map<String, EObject> nameToEdgeB = nodeTypesB.stream()
				.filter(e -> e.eGet(e.eClass().getEStructuralFeature("name")) != null).collect(Collectors
						.toMap(e -> e.eGet(e.eClass().getEStructuralFeature("name")).toString(), e -> e, (e1, e2) -> e1 // bei
																														// Namensdoppelung:
																														// erster
						// gewinnt
						));

		System.out.println("Gefundene Korrespondenzen:");
		mainloop: for (EObject edgeA : nodeTypesA) {

			Collection<EObject> correspondences = getCorrespondencesService().getCorrespondences(edgeA);

			if (correspondences.size() > 1) {
				getCorrespondencesService().removeCorrespondence(edgeA);
			}
			String nameA = edgeA.eGet(edgeA.eClass().getEStructuralFeature("name")).toString();
			for (EObject corresponding : correspondences) {
				String nameB = corresponding.eGet(corresponding.eClass().getEStructuralFeature("name")).toString();
				if (nameA.equals(nameB))
					continue mainloop;
				else {
					getCorrespondencesService().removeCorrespondence(edgeA);
					getCorrespondencesService().removeCorrespondence(corresponding);
				}
			}

			if (nameA != null && nameToEdgeB.containsKey(nameA)) {
				System.out.println("✔ " + nameA + " kommt in beiden Modellen vor.");
				eobjects.add(nameToEdgeB.get(nameA));
				populateCorrespondence(edgeA, nameToEdgeB.get(nameA));
			}
		}

		MatchingModelCorrespondences correspondences = (MatchingModelCorrespondences) getCorrespondencesService();
		Collection<EObject> a1 = getCorrespondencesService().getElementsWithoutCorrespondences(models.get(1));
		List<EObject> toRemove = new ArrayList<EObject>();
		for (EObject eobject : getCorrespondencesService().getElementsWithoutCorrespondences(models.get(1))) {
			if(eobjects.contains(eobject)) {
				toRemove.add(eobject);
			}
		}
		correspondences.getMatching().getUnmatchedB().removeAll(toRemove);
	}

	private void matchEdgeTypes(List<Resource> models) {
		Assert.isTrue(models.size() == 2, "Only 2 models are supported");

		List<EObject> modelAContents = getAllContents(models.get(0));
		List<EObject> modelBContents = getAllContents(models.get(1));

		List<EObject> edgeTypesA = modelAContents.stream().filter(e -> e.eClass().getName().equals("EdgeType"))
				.collect(Collectors.toList());

		List<EObject> edgeTypesB = modelBContents.stream().filter(e -> e.eClass().getName().equals("EdgeType"))
				.collect(Collectors.toList());

		Map<String, EObject> nameToEdgeB = edgeTypesB.stream()
				.filter(e -> e.eGet(e.eClass().getEStructuralFeature("name")) != null).collect(Collectors
						.toMap(e -> e.eGet(e.eClass().getEStructuralFeature("name")).toString(), e -> e, (e1, e2) -> e1 // bei
																														// Namensdoppelung:
																														// erster
						// gewinnt
						));

		System.out.println("Gefundene Korrespondenzen:");
		mainloop: for (EObject edgeA : edgeTypesA) {

			Collection<EObject> correspondences = getCorrespondencesService().getCorrespondences(edgeA);

			if (correspondences.size() > 1) {
				getCorrespondencesService().removeFromCorrespondence(edgeA);
			}
			String nameA = edgeA.eGet(edgeA.eClass().getEStructuralFeature("name")).toString();
			for (EObject corresponding : correspondences) {
				String nameB = corresponding.eGet(corresponding.eClass().getEStructuralFeature("name")).toString();
				if (nameA.equals(nameB))
					continue mainloop;
				else {
					getCorrespondencesService().removeFromCorrespondence(edgeA);
					getCorrespondencesService().removeCorrespondence(corresponding);
				}
			}

			if (nameA != null && nameToEdgeB.containsKey(nameA)) {
				System.out.println("✔ " + nameA + " kommt in beiden Modellen vor.");
				populateCorrespondence(edgeA, nameToEdgeB.get(nameA.toString()));
			}
		}
	}

	private void matchEdgeTypes2(List<Resource> models) {
		Assert.isTrue(models.size() == 2, "Only 2 models are supported");

		List<EObject> eobjects = new ArrayList<EObject>();
		
		List<EObject> modelAContents = getAllContents(models.get(0));
		List<EObject> modelBContents = getAllContents(models.get(1));

		List<EObject> edgeTypesA = modelAContents.stream().filter(e -> e.eClass().getName().equals("EdgeType"))
				.collect(Collectors.toList());

		List<EObject> edgeTypesB = modelBContents.stream().filter(e -> e.eClass().getName().equals("EdgeType"))
				.collect(Collectors.toList());

		Map<String, EObject> nameToEdgeB = edgeTypesB.stream()
				.filter(e -> e.eGet(e.eClass().getEStructuralFeature("name")) != null).collect(Collectors
						.toMap(e -> e.eGet(e.eClass().getEStructuralFeature("name")).toString(), e -> e, (e1, e2) -> e1 // bei
																														// Namensdoppelung:
																														// erster
						// gewinnt
						));

		System.out.println("Gefundene Korrespondenzen:");
		mainloop: for (EObject edgeA : edgeTypesA) {

			Collection<EObject> correspondences = getCorrespondencesService().getCorrespondences(edgeA);

			if (correspondences.size() > 1) {
				getCorrespondencesService().removeCorrespondence(edgeA);
				getCorrespondencesService().removeCorrespondence((EObject[]) correspondences.toArray());
			}
			String nameA = edgeA.eGet(edgeA.eClass().getEStructuralFeature("name")).toString();
			for (EObject corresponding : correspondences) {
				String nameB = corresponding.eGet(corresponding.eClass().getEStructuralFeature("name")).toString();
				if (nameA.equals(nameB))
					continue mainloop;
				else {
					getCorrespondencesService().removeFromCorrespondence(edgeA);
					getCorrespondencesService().removeFromCorrespondence(corresponding);
				}

			}

			if (nameA != null && nameToEdgeB.containsKey(nameA)) {
				System.out.println("✔ " + nameA + " kommt in beiden Modellen vor.");
				eobjects.add(nameToEdgeB.get(nameA.toString()));
				populateCorrespondence(edgeA, nameToEdgeB.get(nameA.toString()));
				continue;
			}

			String srcNameA = getNodeName(edgeA, "src");
			String tgtNameA = getNodeName(edgeA, "tgt");
			Optional<EObject> match = edgeTypesB.stream().filter(edgeB -> {
				String nameB = edgeB.eGet(edgeB.eClass().getEStructuralFeature("name")).toString();

				String nameBsplitted = trimToIndex(nameB);
				String nameAsplitted = trimToIndex(nameA);

				String srcNameB = getNodeName(edgeB, "src");
				String tgtNameB = getNodeName(edgeB, "tgt");

				boolean first = nameAsplitted.equals(nameBsplitted) && srcNameB.contains(srcNameA)
						&& tgtNameB.contains(tgtNameA);
				if (first)
					return true;

				return nameAsplitted.equals(nameBsplitted) && srcNameA.contains(srcNameB)
						&& tgtNameA.contains(tgtNameB);
			}).findFirst();

			if (match.isPresent()) {
				System.out.println("✔ Korrespondenz gefunden:");
				System.out.println("   Modell A: " + nameA + " (" + srcNameA + " → " + tgtNameA + ")");
				EObject edgeB = match.get();
				System.out.println("   Modell B: " + edgeB.eGet(edgeB.eClass().getEStructuralFeature("name")).toString()
						+ " (" + getNodeName(edgeB, "src") + " → " + getNodeName(edgeB, "tgt") + ")");
				eobjects.add(edgeB);
				populateCorrespondence(edgeA, edgeB);
			}
		}
		
		MatchingModelCorrespondences correspondences = (MatchingModelCorrespondences) getCorrespondencesService();
		Collection<EObject> a1 = getCorrespondencesService().getElementsWithoutCorrespondences(models.get(1));
		List<EObject> toRemove = new ArrayList<EObject>();
		for (EObject eobject : getCorrespondencesService().getElementsWithoutCorrespondences(models.get(1))) {
			if(eobjects.contains(eobject)) {
				toRemove.add(eobject);
			}
		}
		correspondences.getMatching().getUnmatchedB().removeAll(toRemove);

	}

	private String trimToIndex(String input) {
		int index = input.indexOf('('); // oder '[' oder '{' je nach Fall
		if (index == -1) {
			return input; // keine Klammer gefunden → Rückgabe des Originals
		}
		return input.substring(0, index).trim();
	}

	private String getNodeName(EObject edgeB, String string) {
		EObject type = (EObject) edgeB.eGet(edgeB.eClass().getEStructuralFeature(string));
		return type.eGet(type.eClass().getEStructuralFeature("name")).toString();
	}

	private void populateCorrespondence(EObject left, EObject right) {
		if (left != null && right != null) {

			getCorrespondencesService().addCorrespondence(left, right);

		}

	}

	public void findEdgeTypeCorrespondences(List<Resource> models) {
		if (models.size() != 2) {
			throw new IllegalArgumentException("Es werden genau zwei Modelle erwartet.");
		}

	}

	private List<EObject> getAllContents(Resource resource) {
		List<EObject> result = new ArrayList<>();
		for (EObject root : resource.getContents()) {
			collectAllContents(root, result);
		}
		return result;
	}

	private void collectAllContents(EObject obj, List<EObject> result) {
		result.add(obj);
		for (EObject child : obj.eContents()) {
			collectAllContents(child, result);
		}
	}

}
