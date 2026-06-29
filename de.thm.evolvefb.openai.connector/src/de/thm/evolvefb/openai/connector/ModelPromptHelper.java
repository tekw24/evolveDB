package de.thm.evolvefb.openai.connector;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.eclipse.emf.ecore.resource.Resource;

public class ModelPromptHelper {

    private static final String COMPARISON_TEMPLATE = """
              
                Compare the following two mdde model instances according to the system instructions.

                The old/source model is enclosed between <OLD_MODEL_XMI> and </OLD_MODEL_XMI>.
                The new/target model is enclosed between <NEW_MODEL_XMI> and </NEW_MODEL_XMI>.

                Rules:
                - Use the system prompt as the authoritative instruction.
                - Treat OLD_MODEL_XMI as Model A / old version / source model.
                - Treat NEW_MODEL_XMI as Model B / new version / target model.
                - Use only rule IDs from the rule catalog in the system prompt.
                - Return exactly one valid JSON object.
                - Do not return Markdown.
                - Do not add text before or after the JSON.

                <OLD_MODEL_XMI>
                %s
                </OLD_MODEL_XMI>

                <NEW_MODEL_XMI>
                %s
                </NEW_MODEL_XMI>
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