package client_server.facade.populator;


public interface Populator<Source, Target> {

    void populate(Target target, Source source);
}
