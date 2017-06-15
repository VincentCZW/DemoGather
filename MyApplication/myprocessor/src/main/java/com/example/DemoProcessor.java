package com.example;


import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;

@AutoService(Processor.class)
public class DemoProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotationTypes = new LinkedHashSet<>();
        annotationTypes.add(AnnoField.class.getCanonicalName());
        annotationTypes.add(AnnoMethod.class.getCanonicalName());
        return annotationTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_7;
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        StringBuilder builder = new StringBuilder()
                .append("package com.example.vincent.generate;\n\n")
                .append("public class GeneratedClass {\n\n") // open class
                .append("\tpublic String getMessage() {\n") // open method
                .append("\t\treturn \"");
        Messager msg = processingEnv.getMessager();
        // for each javax.lang.model.element.Element annotated with the CustomAnnotation
        for (Element element : roundEnv.getElementsAnnotatedWith(AnnoField.class)) {
            String objectType = element.getSimpleName().toString();
            // this is appending to the return statement
            builder.append(objectType).append(" says hello!\\n");
        }

        builder.append("\";\n") // end return
                .append("\t}\n") // close method
                .append("}\n"); // close class

        try { // write the file
            JavaFileObject source = processingEnv.getFiler().createSourceFile("com.example.vincent.generate.GeneratedClass");
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // Note: calling e.printStackTrace() will print IO errors
            // that occur from the file already existing after its first run, this is normal
        }


        for (Element element : roundEnv.getElementsAnnotatedWith(AnnoField.class)) {
            if (element == null) {
                System.out.print("--- element = null ---" +  + '\n');
                continue;
            }
            System.out.print("---" + element.toString() + "---" + '\n');
            AnnoField annoField = element.getAnnotation(AnnoField.class);
            System.out.print("---" + annoField.toString() + "---" + '\n');
            VariableElement variableElement = (VariableElement) element;
            TypeElement classElement = (TypeElement) element.getEnclosingElement();
            TypeMirror typeMirror = variableElement.asType();
            String type = typeMirror.toString();
            System.out.print("***  " + classElement.getQualifiedName() + "  ***" + '\n');
            System.out.print("***  " + classElement.getSimpleName() + "  ***" + '\n');
            System.out.print("***  " + variableElement.getSimpleName() + "  ***" + '\n');
            System.out.print("***  " + type + "  ***" + '\n');
            System.out.print("***  " + annoField.value() + "  ***" + '\n');
        }


        for (Element element : roundEnv.getElementsAnnotatedWith(AnnoMethod.class)) {
            if (element == null) {
                System.out.print("--- element = null ---" + '\n');
                continue;
            }
            System.out.print("---" + element.toString() + "---" + '\n');
            AnnoMethod annoMethod = element.getAnnotation(AnnoMethod.class);
            System.out.print("---" + annoMethod.toString() + "---" + '\n');
        }
        return true;
    }
}
