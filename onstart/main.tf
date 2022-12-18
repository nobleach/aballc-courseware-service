provider "aws" {
  region = "us-east-1"
  access_key = "123"
  secret_key = "xyz"
  skip_credentials_validation = true
  skip_requesting_account_id = true
  skip_metadata_api_check = true
  s3_force_path_style = true
  endpoints {
    sqs      = "http://localhost:4566"
    s3       = "http://localhost:4566"
    iam      = "http://localhost:4566"
  }
}

resource "aws_s3_bucket" "source" {
  bucket = "source"
  acl    = "public-read"
}

resource "aws_s3_bucket" "destination" {
  bucket = "videos"
  acl    = "public-read"
}

resource "aws_sqs_queue" "download_bundle_queue" {
  name                      = "download-bundle-queue"
  delay_seconds             = 5
  max_message_size          = 262144
  message_retention_seconds = 86400
  receive_wait_time_seconds = 5

  tags = {
    Environment = "development"
  }
}

resource "aws_iam_role" "iam_for_bundler" {
  name = "iam_for_bundler"

  assume_role_policy = <<EOF
  {
    "Version": "2012-10-17",
    "Statement": [
      {
        "Action": "sts:AssumeRole",
        "Principal": {
          "Service": "lambda.amazonaws.com"
        },
        "Effect": "Allow",
        "Sid": "123"
      }
    ]
  }
  EOF
}
