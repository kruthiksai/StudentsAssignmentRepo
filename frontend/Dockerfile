FROM nginx:alpine

# Copy static files
COPY . /usr/share/nginx/html

# Copy custom template and start script
COPY nginx.template.conf /etc/nginx/nginx.template.conf
COPY start.sh /start.sh
RUN chmod +x /start.sh

# Use start script as entrypoint
ENTRYPOINT ["/start.sh"]

EXPOSE 80
