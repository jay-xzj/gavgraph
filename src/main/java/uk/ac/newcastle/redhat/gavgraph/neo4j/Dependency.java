package uk.ac.newcastle.redhat.gavgraph.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity("DEPEND_ON")
public class Dependency {
    @Id
    @GeneratedValue
    private Long id;

    //@JsonIgnore
    @StartNode
    private Artifact start;

    @EndNode
    private Artifact end;

}
