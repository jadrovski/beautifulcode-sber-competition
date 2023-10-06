rootProject.name = "brackets-service"

include(
  "infrastructure:bootstrap",
  "infrastructure:api",
  "application",
  "domain"
)

includeBuild("../shared")