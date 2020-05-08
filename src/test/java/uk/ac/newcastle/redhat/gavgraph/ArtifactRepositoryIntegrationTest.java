package uk.ac.newcastle.redhat.gavgraph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.newcastle.redhat.gavgraph.neo4j.Artifact;
import uk.ac.newcastle.redhat.gavgraph.neo4j.ArtifactRepository;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test demonstrating the use of ArtifactRepository
 *
 * @author jayxu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArtifactRepositoryIntegrationTest {

    @SpringBootApplication
    static class ExampleConfig {}

    @Autowired
    ArtifactRepository artifactRepository;

    /**
     *
     */
    @Test
    public void testSaveAndLoadArtifact(){
        Artifact log4j2 = new Artifact(
                "org.springframework.boot",
                "spring-boot-starter-log4j2",
                "2.2.6.release");
        log4j2.dependOn("org.apache.logging.log4j",
                "log4j-core",
                "2.12.1");
        artifactRepository.save(log4j2);
        assertThat(artifactRepository.findById(log4j2.getId()))
                .hasValueSatisfying(artifact -> {
                    assertThat(artifact.getGroupId()).isEqualTo(log4j2.getGroupId());
                    assertThat(artifact.getArtifactId()).isEqualTo(log4j2.getArtifactId());
                    assertThat(artifact.getVersion()).isEqualTo(log4j2.getVersion());
                    assertThat(artifact.getDependencies()).hasSize(1).first()
                            .satisfies(dependency->{
                                assertThat(dependency.getGroupId()).isEqualTo("org.apache.logging.log4j");
                                assertThat(dependency.getArtifactId()).isEqualTo("log4j-core");
                                assertThat(dependency.getVersion()).isEqualTo("2.12.1");
                            });
                });

    }
}
