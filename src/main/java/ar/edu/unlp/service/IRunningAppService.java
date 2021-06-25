package ar.edu.unlp.service;

import ar.edu.unlp.model.RunningApp;

public interface IRunningAppService {

    RunningApp findFirstByOrderById();
}
