module notes.rest {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.data.rest.core;
    requires spring.data.commons;
    requires spring.web;
    requires transitive spring.webmvc;

    requires transitive notes.core;
    // requires transitive notes.json;
    requires transitive com.fasterxml.jackson.databind;

    opens rest to spring.beans, spring.context, spring.web, spring.core;
    // exports notes.rest.properties to spring.beans, spring.boot;
    exports rest;
}
