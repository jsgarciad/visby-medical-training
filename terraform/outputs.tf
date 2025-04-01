 output "app_engine_application_url" {
  value = "https://${google_app_engine_application.app.default_host}"
}

output "app_engine_application_name" {
  value = google_app_engine_application.app.name
}

output "app_engine_application_location" {
  value = google_app_engine_application.app.location_id
}   