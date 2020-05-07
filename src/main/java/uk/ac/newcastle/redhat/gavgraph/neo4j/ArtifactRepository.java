package uk.ac.newcastle.redhat.gavgraph.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.List;

public interface ArtifactRepository extends Neo4jRepository<Artifact, Long> {

    /**
     * Nested property from select from roles -> movie -> title,
     * where this here represents the start node in a
     * relationship and movie the end node.
     *
     * @param artifactId
     * @return
     */
    List<Artifact> findAllByArtifactIdAndGroupId(String artifactId);

    /**
     *
     * @param rangeList a artifact range list which are already not available
     * @return
     */
    List<Artifact> findAllByArtifactIdAndGroupIdRange(List<Artifact> rangeList);

    List<Artifact> findAllDependenciesByArtifactId(String artifactId);


}
