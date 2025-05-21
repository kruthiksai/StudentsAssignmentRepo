FROM nginx:alpine

COPY . /usr/share/nginx/html/
COPY nginx.template.conf /etc/nginx/nginx.template.conf

EXPOSE 80

CMD sh -c "sed -i \"s|<head>|<head><base href='/${STUDENT_ID}/'>|\" /usr/share/nginx/html/index.html && \
envsubst '\$BACKEND_API_URL' < /etc/nginx/nginx.template.conf > /etc/nginx/nginx.conf && \
nginx -g 'daemon off;'"