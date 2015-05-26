/*
 * Name: {TUTableStreamUpdater.js}
 * Module: {}
 * Location: {Norris/test/unit}
 * Date: {2015-05-26}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-26 Kaizen Team {creation}
 * ================================================================================
 */

describe('TableStreamUpdater', function(){
    beforeEach(module('norris-chartupdater'));

    var TableStreamUpdater;

    beforeEach(inject(function($injector) {
        TableStreamUpdater = $injector.get('TableStreamUpdater');
    }));

    describe('update(chart: ChartImpl, updateData: ChartUpdate): void', function(){
        it('should not accept a chart without data',function(){
            var chart = {
                data: {},
                settings: {
                    maxRows: 10
                }
            };
            chart.getData = function() {return this.data;};
            chart.setData = function(data) {this.data = data;};
            chart.getSettings = function() {return this.settings;};
            var newData = [
                [{value: '9999'}, {value: '8888'}, {value: '7777'}],
                [{value: '6666'}, {value: '5555'}, {value: '4444'}]
            ];
            expect(function () {(new TableStreamUpdater()).update(chart, newData)}).toThrow();
        });
        it('should reject an update whose data length is different from datasets length of the chart',function(){
            var chart = {
                data: {
                    headers: ['col1','col2','col3'],
                    datasets: [
                        [ {value: '1'}, {value: '2'}, {value: '3'} ],
                        [ {value: '1'}, {value: '1'}, {value: '1'} ]
                    ]
                },
                settings: {
                    maxRows: 10
                }
            };
            chart.getData = function() {return this.data;};
            chart.setData = function(par) {this.data = par;};
            chart.getSettings = function() {return this.settings;};
            var newData = [
                [ {value: '9999'}, {value: '8888'}, {value: '7777'}, {value: 'tooMuch1'} ],
                [ {value: '6666'}, {value: '5555'}, {value: '4444'}, {value: 'tooMuch2'} ]
            ];
            expect(function () {(new TableStreamUpdater()).update(chart, newData)}).toThrow();
        });
        it('should update a given chart with the stream method', function(){
            var chart = {
                data: {
                    headers: ['col1','col2','col3'],
                    datasets: [
                        [ {value: '1'}, {value: '2'}, {value: '3'} ],
                        [ {value: '1'}, {value: '1'}, {value: '1'} ]
                    ]
                },
                settings: {
                    maxRows: 10
                }
            };
            chart.getData = function() {return this.data;};
            chart.setData = function(par) {this.data = par;};
            chart.getSettings = function() {return this.settings;};
            var newData = [
                [ {value: '9999'}, {value: '8888'}, {value: '7777'} ],
                [ {value: '6666'}, {value: '5555'}, {value: '4444'} ]
            ];
            var updatedData = {
                headers: ['col1','col2','col3'],
                datasets: [
                    [ {value: '1'}, {value: '2'}, {value: '3'} ],
                    [ {value: '1'}, {value: '1'}, {value: '1'} ],
                    [ {value: '9999'}, {value: '8888'}, {value: '7777'} ],
                    [ {value: '6666'}, {value: '5555'}, {value: '4444'} ]
                ]
            };
            (new TableStreamUpdater()).update(chart, newData);
            expect(updatedData).toEqual(chart.data);
        });
    });
    
});