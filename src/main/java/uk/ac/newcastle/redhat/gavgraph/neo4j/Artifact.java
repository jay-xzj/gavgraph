package uk.ac.newcastle.redhat.gavgraph.neo4j;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * This class will be like a node in a linked list or a graph,
 * there should be some 前继节点 and 后继节点
 */
@NodeEntity(label = "Artifact")
//logging level ...
public class Artifact {

    //a predecessor is a artifact that depends on this artifact.
    private @Relationship(type = "DEPEND_ON",direction = Relationship.INCOMING) Artifact predecessor;
    private @Id @GeneratedValue Long id;
    private String groupId;
    private String artifactId;
    private String version;
    private @Relationship(type = "DEPEND_ON")//Direction of the relationship. Defaults to OUTGOING.
    Set<Artifact> dependencies = new HashSet<>();

    public Artifact(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public Artifact(Artifact predecessor, String groupId, String artifactId, String version, HashSet<Artifact> dependencies) {
        this.predecessor = predecessor;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.dependencies = dependencies;
    }

    /**
     * depend on a single dependency artifact, so here will be the dependency's groupId, artifactId and version
     */
    public void dependOn(String groupId,String artifactId,String version){
        Artifact dependency = new Artifact(this, groupId, artifactId, version, new HashSet<Artifact>());
        dependencies.add(dependency);
    }

    public Artifact getPredecessor() {
        return predecessor;
    }

    public Long getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    public Set<Artifact> getDependencies() {
        return dependencies;
    }
}
