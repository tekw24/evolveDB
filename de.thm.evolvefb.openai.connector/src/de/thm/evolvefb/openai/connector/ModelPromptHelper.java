package de.thm.evolvefb.openai.connector;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.eclipse.emf.ecore.resource.Resource;

public class ModelPromptHelper {

    private static final String COMPARISON_TEMPLATE = """
            Vergleiche die folgenden zwei Instanzen des Ecore-Metamodells 'mdde', \
            die relationale Datenbankschemata beschreiben.

            Aufgabe:
            - Bestimme alle relevanten Unterschiede zwischen Modell A und Modell B.
            - Berücksichtige u.a.:
              * hinzugefügte / gelöschte Tabellen
              * umbenannte Tabellen
              * hinzugefügte / gelöschte / geänderte Spalten
              * Änderungen an Datentypen, Not-Null, Default-Werten, Auto-Increment
              * Änderungen an Primary Keys, Foreign Keys und Constraints
              * Änderungen an referentiellen Aktionen (OnUpdate, OnDelete)
            - Beschreibe die Unterschiede möglichst präzise und beziehe dich auf die Namen der Elemente.

            Gib die Antwort in gut lesbarem Text, gegliedert nach Tabellen.

            Modell A (z.B. alte Version):
            ```xmi
            %s
            ```

            Modell B (z.B. neue Version):
            ```xmi
            %s
            ```
            """;

    public static String buildComparisonPrompt(Resource modelA, Resource modelB) {
        String xmiA = serializeResourceToXmi(modelA);
        String xmiB = serializeResourceToXmi(modelB);
        return String.format(COMPARISON_TEMPLATE, xmiA, xmiB);
    }

    private static String serializeResourceToXmi(Resource resource) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            resource.save(out, null); // null = Default-Save-Options
            return out.toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Serialisieren der EMF-Resource", e);
        }
    }
}