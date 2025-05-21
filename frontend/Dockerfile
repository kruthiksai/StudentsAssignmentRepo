FROM nginx:alpine

ARG STUDENT_ID
ARG BACKEND_API_URL

ENV STUDENT_ID=${STUDENT_ID}
ENV BACKEND_API_URL=${BACKEND_API_URL}

COPY . /usr/share/nginx/html/
COPY nginx.template.conf /etc/nginx/nginx.template.conf

CMD sh -c "\
  envsubst '\$STUDENT_ID' < /usr/share/nginx/html/index.template.html > /usr/share/nginx/html/index.html && \
  envsubst '\$BACKEND_API_URL' < /etc/nginx/nginx.template.conf > /etc/nginx/nginx.conf && \
  nginx -g 'daemon off;'"
