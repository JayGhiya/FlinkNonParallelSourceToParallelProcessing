package org.quarkus.trireme.module.models;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root r
oot = om.readValue(myJsonString), Root.class); */
class AllowNonRestoredState{
    public String type;
}

class EntryClass{
    public String type;
}

class JobId{
    public String type;
}

class Parallelism{
    public String type;
}

class ProgramArgs{
    public String type;
}

class Items{
    public String type;
}

class ProgramArgsList{
    public String type;
    public Items items;
}

class SavepointPath{
    public String type;
}

class JobStartProperties{
    public AllowNonRestoredState allowNonRestoredState;
    public EntryClass entryClass;
    public JobId jobId;
    public Parallelism parallelism;
    public ProgramArgs programArgs;
    public ProgramArgsList programArgsList;
    public SavepointPath savepointPath;
}

public class JobStartRequest{
    public String type;
    public String id;
    public JobStartProperties properties;
}

