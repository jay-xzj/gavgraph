package uk.ac.newcastle.redhat.gavgraph.neo4j;

import java.util.List;

public interface ArtifactService {

    List<Artifact> retrieveAllArtifacts();

    Artifact addArtifact(Artifact artifact);
}
