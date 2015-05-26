/*
 * Name: {TULineChartInPlaceUpdater.js}
 * Module: {}
 * Location: {Norris/test/unit}
 * Date: {2015-05-25}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-25 Kaizen Team {creation}
 * ================================================================================
 */

describe('LineChartInPlaceUpdater', function(){
    beforeEach(module('norris-chartupdater'));

    var LineChartInPlaceUpdater;
    
    beforeEach(inject(function($injector) {
        LineChartInPlaceUpdater = $injector.get('LineChartInPlaceUpdater');
    }));

    describe('update(chart: ChartImpl, updateData: ChartUpdate): void', function(){
        it('should reject chart without data',function(){
            var chart = {data: {}};
            chart.getData = function() {return this.data;};
            chart.setData = function(data) {this.data = data;};
            var newData = [
                { position: {x:0, y:0}, value: 'foo' },
                { position: {x:0, y:1}, value: 'foo' }
            ]
            expect(function () {(new LineChartInPlaceUpdater()).update(chart, newData)}).toThrow();
        });
        it('should update a given linechart with the inplace method',function(){
            var chart = {
                data: {
                    datasets: [
                        {values: [1,2,3,4]},
                        {values: [1,2,3,4]},
                        {values: [1,2,3,4]}
                    ]
                }
            };
            chart.getData = function() {return this.data;};
            chart.setData = function(par) {this.data = par;};
            var newData = [
                { position: {x:0, y:0}, value: 'foo' },
                { position: {x:0, y:1}, value: 'foo' }
            ];
            var updatedData = {
                datasets: [
                    {values: ['foo','foo',3,4]},
                    {values: [1,2,3,4]},
                    {values: [1,2,3,4]}
                ]
            };
            (new LineChartInPlaceUpdater()).update(chart, newData);
            expect(updatedData).toEqual(chart.data);
        });
    });
});