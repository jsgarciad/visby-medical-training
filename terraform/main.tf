provider "google" {
  project = "visby-training"
  region  = "us-central1"
}

resource "google_app_engine_application" "app" {
  project = "visby-training"
  location_id = "us-central"
}


