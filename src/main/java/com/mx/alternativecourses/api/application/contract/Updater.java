package com.mx.alternativecourses.api.application.contract;

public interface Updater<ToUpdate, Input> {

	ToUpdate update(ToUpdate entity, Input data);

}

