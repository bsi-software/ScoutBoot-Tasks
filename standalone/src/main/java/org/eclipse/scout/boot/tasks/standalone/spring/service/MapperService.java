package org.eclipse.scout.boot.tasks.standalone.spring.service;

import org.modelmapper.ModelMapper;

public interface MapperService<MODEL, ENTITY> {

  default ModelMapper getMapper() {
    return new ModelMapper();
  }

  default MODEL convertToModel(ENTITY text, Class<MODEL> clazz) {
    return (MODEL) getMapper().map(text, clazz);
  }

  default ENTITY convertToEntity(MODEL text, Class<ENTITY> clazz) {
    return (ENTITY) getMapper().map(text, clazz);
  }

}
