FROM ruby:2.4-alpine

WORKDIR /app
COPY Gemfile Gemfile.lock ./
RUN bundle install
COPY server.rb .

CMD ["ruby", "server.rb"]
