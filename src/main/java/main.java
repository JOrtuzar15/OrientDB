import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.ODatabaseType;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OVertex;

public class main {
    public static void main(String[] args){
        OrientDB orient = new OrientDB("remote:localhost","root","rootpwd",null);

        if (orient.open("database_as", "root", "rootpwd", null) == null) {
            orient.create("database_as", ODatabaseType.PLOCAL);
        }
        ODatabaseSession db = orient.open("database_as","root","rootpwd");

        OClass persona = db.getClass("Persona");
        if (persona == null){
            db.createVertexClass("Persona");
        }

        if (persona.getProperty("nombre") == null){
            persona.createProperty("nombre", OType.STRING);
        }

        if (persona.getProperty("sexo") == null){
            persona.createProperty("sexo", OType.STRING);
        }

        OVertex registro = db.newVertex("Persona");
        registro.setProperty("nombre","Jon");
        registro.setProperty("sexo","Hombre");
        registro.save();

        db.close();
        orient.close();
    }
}
