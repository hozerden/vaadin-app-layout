package com.github.appreciated.app.layout.builder.factories;

import com.github.appreciated.app.layout.annotations.MenuCaption;
import com.github.appreciated.app.layout.annotations.MenuIcon;
import com.github.appreciated.app.layout.builder.AppLayoutConfiguration;
import com.github.appreciated.app.layout.builder.entities.NavigationElementInfo;
import com.github.appreciated.app.layout.builder.interfaces.Factory;
import com.vaadin.navigator.View;
import com.vaadin.server.Resource;

public class BasicViewInfoProducer implements AppLayoutConfiguration.NavigationElementInfoProducer {

    private AnnotationValueProvider<String> captionProvider = info -> info.getAnnotation(MenuCaption.class).value();
    private AnnotationValueProvider<Resource> iconProvider = info -> info.getAnnotation(MenuIcon.class).value();
    private AnnotationValueProvider<String> viewNameProvider;

    public BasicViewInfoProducer(AnnotationValueProvider<String> viewNameProvider) {
        this.viewNameProvider = viewNameProvider;
    }

    public BasicViewInfoProducer() {
    }

    public BasicViewInfoProducer withCaptionProvider(AnnotationValueProvider<String> captionProvider) {
        this.captionProvider = captionProvider;
        return this;
    }

    public BasicViewInfoProducer withIconProvider(AnnotationValueProvider<Resource> iconProvider) {
        this.iconProvider = iconProvider;
        return this;
    }

    public BasicViewInfoProducer withViewNameProvider(AnnotationValueProvider<String> viewNameProvider) {
        this.viewNameProvider = viewNameProvider;
        return this;
    }

    @Override
    public NavigationElementInfo apply(Class<? extends View> info) {
        return new NavigationElementInfo(
                captionProvider.get(info),
                iconProvider.get(info),
                viewNameProvider.get(info)
        );
    }

    public interface AnnotationValueProvider<T> extends Factory<T, Class<? extends View>> {
    }
}