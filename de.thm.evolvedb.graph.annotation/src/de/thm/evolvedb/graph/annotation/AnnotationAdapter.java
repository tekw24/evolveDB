package de.thm.evolvedb.graph.annotation;

import java.util.List;
import org.eclipse.emf.common.notify.impl.AdapterImpl;


public class AnnotationAdapter extends AdapterImpl {

    private final List<AnnotationEntry> annotations;

    public AnnotationAdapter(List<AnnotationEntry> annotations) {
        this.annotations = annotations;
    }

    public List<AnnotationEntry> getAnnotations() {
        return annotations;
    }

    @Override
    public boolean isAdapterForType(Object type) {
        return type == AnnotationAdapter.class;
    }
}