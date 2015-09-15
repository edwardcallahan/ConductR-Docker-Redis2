# Example Redis Docker Container as a ConductR Bundle

Example of running Redis in a container on ConductR

## Use

Run `sbt bundle:dist` generate a bundle that can be loaded and started in [ConductR](https://conductr.typesafe.com).

##

```bash
dockerCommands := Seq(
      Cmd("FROM", "redis:2")
    ),
```

For additional information, please see the [ConductR Documentation](https://conductr.typesafe.com)

