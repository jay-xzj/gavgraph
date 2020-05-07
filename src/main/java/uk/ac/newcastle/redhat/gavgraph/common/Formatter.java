package uk.ac.newcastle.redhat.gavgraph.common;

import org.apache.maven.model.Dependency;

public class Formatter {

    /**
     * {groupId=junit, artifactId=junit, version=4.12, type=jar} → junit:junit:jar:4.12
     * @return
     */
    public static String format(Dependency dependency){
        String groupId = dependency.getGroupId();
        String artifactId = dependency.getArtifactId();
        String version = dependency.getVersion();
        return null;
    }

}
