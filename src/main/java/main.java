import com.orientechnologies.orient.core.db.ODatabaseType;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OVertex;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OrientDB orient = new OrientDB("remote:orientdb_orientdb_1:2424","root","rootpwd", OrientDBConfig.defaultConfig());

        if (!orient.exists("database_as")) {
            orient.create("database_as", ODatabaseType.PLOCAL);
        }
        ODatabaseDocument db = orient.open("database_as","root","rootpwd");

        OClass persona = db.getClass("Persona");
        if (persona == null) {
            db.createVertexClass("Persona");
            persona = db.getClass("Persona");
            persona.createProperty("nombre", OType.STRING);
            persona.createProperty("sexo", OType.STRING);
        }

        OVertex registro = db.newVertex("Persona");
        registro.setProperty("nombre","Jon");
        registro.setProperty("sexo","Hombre");
        registro.save();

        System.out.println(db.getStatus());

        db.close();
        orient.close();
    }
}
