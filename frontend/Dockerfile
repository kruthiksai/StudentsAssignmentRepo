FROM nginx:alpine

# Accept student ID at build time
ARG STUDENT_ID
ENV STUDENT_ID=${STUDENT_ID}

# Copy all static files first
COPY . /usr/share/nginx/html/

# Inject <base href="/STUDENT_ID/"> into index.html
RUN sed -i "s|<head>|<head><base href='/${STUDENT_ID}/'>|" /usr/share/nginx/html/index.html

# Use default nginx entrypoint
EXPOSE 80
