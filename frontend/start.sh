#!/bin/sh

# Replace placeholder with environment variable in nginx template
envsubst '$BACKEND_API_URL' < /etc/nginx/nginx.template.conf > /etc/nginx/nginx.conf

# Start NGINX
nginx -g 'daemon off;'
