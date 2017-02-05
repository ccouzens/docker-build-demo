require 'socket'
require 'faker'

def who
  Faker::Name.name
end

def response
  %{
  HTTP/1.0 200 OK
  Content-Type: text/html

  <h1>Hello #{who}</h1>
  }.strip.split("\n").map(&:strip).join("\r\n")
end

PORT = 8080

STDOUT.sync = true

server = TCPServer.new('0.0.0.0', PORT)

puts "listening on port: #{PORT}"

loop do
  socket = server.accept
  puts socket.gets
  socket.print response
  socket.close
end
