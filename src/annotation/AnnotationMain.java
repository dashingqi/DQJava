package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationMain {

    public final String TAG_1 = "tag_1";

    public final String TAG_2 = "tag_2";

    public static void main(String[] args) {

    }

    public static void printTag(String tag) {
        System.out.println("tag == " + tag);
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.TYPE_PARAMETER})
    @interface Tag {

    }
}
