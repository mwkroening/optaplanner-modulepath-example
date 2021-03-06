package io.github.mwkroening.optaplannermodulepathexample;

import io.github.mwkroening.optaplannermodulepathexample.domain.CloudBalance;
import io.github.mwkroening.optaplannermodulepathexample.domain.CloudComputer;
import io.github.mwkroening.optaplannermodulepathexample.domain.CloudProcess;
import java.util.List;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class App {

  public static void main(String[] args) {
    SolverFactory<CloudBalance> solverFactory =
        SolverFactory.createFromXmlResource(
            "io/github/mwkroening/optaplannermodulepathexample/solver/cloudBalancingSolverConfig.xml");
    Solver<CloudBalance> solver = solverFactory.buildSolver();

    CloudBalance unsolvedCloudBalance =
        new CloudBalance(
            List.of(new CloudComputer(1, 1, 1, 1)), List.of(new CloudProcess(1, 1, 1)));

    CloudBalance solvedCloudBalance = solver.solve(unsolvedCloudBalance);
  }
}
