package uk.ac.newcastle.redhat.gavgraph.neo4j;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArtifactServiceImpl implements ArtifactService{

    @Resource
    private ArtifactRepository artifactRepository;

    @Override
    public List<Artifact> retrieveAllArtifacts() {
        return (List<Artifact>) artifactRepository.findAll();
    }

    @Override
    public Artifact addArtifact(Artifact artifact) {
        return artifactRepository.save(artifact);
    }
}
