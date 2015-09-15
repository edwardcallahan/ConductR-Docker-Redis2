# Example Redis Docker Container as a ConductR Bundle

Example of running Redis in a container on ConductR

## Use

Run `sbt bundle:dist` generate a bundle that can be loaded and started in [ConductR](https://conductr.typesafe.com).

## About

This project uses Docker commands in build.sbt to bundle the `redis:2` tag.

```bash
dockerCommands := Seq(
      Cmd("FROM", "redis:2")
    ),
```

A default bundle.conf is also provided.

For additional information, please see the [ConductR Documentation](https://conductr.typesafe.com)

