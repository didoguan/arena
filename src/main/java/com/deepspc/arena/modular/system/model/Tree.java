package com.deepspc.arena.modular.system.model;

import java.util.List;

public interface Tree {

    String getNodeId();

    String getNodeParentId();

    void setChildrenNodes(List childrenNodes);
}
