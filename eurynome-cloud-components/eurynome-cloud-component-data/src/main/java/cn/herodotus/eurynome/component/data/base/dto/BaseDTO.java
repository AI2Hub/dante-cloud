package cn.herodotus.eurynome.component.data.base.dto;

import cn.herodotus.eurynome.component.data.base.entity.AbstractEntity;

public abstract class BaseDTO extends AbstractEntity {

    @Override
    public String getLinkedProperty() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
