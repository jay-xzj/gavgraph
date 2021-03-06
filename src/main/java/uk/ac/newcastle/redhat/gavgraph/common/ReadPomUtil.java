package uk.ac.newcastle.redhat.gavgraph.common;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.omg.PortableServer.POA;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class ReadPomUtil {

    /**
     * model==antlr:antlr:jar:2.7.7.redhat-7
     * @param fileName
     * @return
     * @throws IOException
     * @throws XmlPullParserException
     */
    public String getCoordinate(String fileName) throws IOException, XmlPullParserException {
        File pom = new File(fileName);
        MavenXpp3Reader pomReader = new MavenXpp3Reader();
        Model model = pomReader.read(new FileReader(pom));
        //ifnotnull
        return model.getGroupId()+":"+model.getArtifactId()+":"+model.getVersion();
    }

    public static Map<String,String> getDependencyRelationships(String fileName) throws IOException, XmlPullParserException {
        File pom = new File(fileName);
        MavenXpp3Reader pomReader = new MavenXpp3Reader();
        Model model = pomReader.read(new FileReader(pom));
        String ms = model.toString();
        List<Dependency> dependencies = model.getDependencies();
        Map<String, String> map = new HashMap<>();
        //dependencies.forEach(dependency -> map.put(ms,));
        dependencies.forEach(System.out::println);
        return null;
    }

    public static void main(String[] args) throws IOException, XmlPullParserException {
        //Map<String, String> map = getDependencyRelationships("src\\main\\resources\\static\\xml\\hibernate-2.1.8-atlassian-34.pom");
        MavenXpp3Reader pomReader = new MavenXpp3Reader();
        Model model = pomReader.read(new FileReader("src\\main\\resources\\static\\xml\\hibernate-2.1.8-atlassian-34.pom"));
        String ms = model.toString();
        List<Dependency> dependencies = model.getDependencies();
        dependencies.forEach(dependency -> System.out.println(dependency.getGroupId()+":"+dependency.getArtifactId()+":"+dependency.getVersion()));

    }

}
