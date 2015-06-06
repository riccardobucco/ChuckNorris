angular.module('chuck', ['chuck-requester', 'chuck-libs']);
angular.module('chuck-requester', ['chuck-chart', 'chuck-libs']);
angular.module('chuck-chart', ['norris-chartupdater']);
angular.module('norris-chartupdater', []);
angular.module('chuck-libs', []);