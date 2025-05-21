FROM nginx:alpine

# Accept build-time args
ARG STUDENT_ID
ARG BACKEND_API_URL

# Set runtime environment variables
ENV STUDENT_ID=${STUDENT_ID}
ENV BACKEND_API_URL=${BACKEND_API_URL}

# Copy app files and template
COPY . /usr/share/nginx/html/
COPY nginx.template.conf /etc/nginx/nginx.template.conf

EXPOSE 80

# CMD with logging and variable expansion
CMD /bin/sh -c " \
  echo '📛 STUDENT_ID = $STUDENT_ID'; \
  echo '🔗 BACKEND_API_URL = $BACKEND_API_URL'; \
  sed -i \"s|<head>|<head><base href='/$STUDENT_ID/'>|\" /usr/share/nginx/html/index.html; \
  envsubst '\$BACKEND_API_URL' < /etc/nginx/nginx.template.conf > /etc/nginx/nginx.conf; \
  echo '🚀 Starting NGINX...'; \
  nginx -g 'daemon off;'"

