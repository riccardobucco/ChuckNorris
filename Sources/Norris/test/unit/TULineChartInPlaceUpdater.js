/*
 * Name: TULineChartInPlaceUpdater.js
 * Module: 
 * Location: Norris/test/unit
 * Date: 2015-05-25
 * Version: v0.01
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.01 2015-05-25 Bucco Riccardo Creation
 * ================================================================================
 */

var LineChartInPlaceUpdater = require('../../main/DataModel/NorrisChart/LineChartInPlaceUpdater.js');
var assert = require("assert");

describe('LineChartInPlaceUpdater', function(){

    describe('update(chart: ChartImpl, updateData: ChartUpdate): void', function(){
        it('should reject chart without data',function(){
            var chart = {data: {}};
            chart.getData = function() {return this.data;};
            chart.setData = function(data) {this.data = data;};
            var newData = [
                { position: {x:0, y:0}, value: 'foo' },
                { position: {x:0, y:1}, value: 'foo' }
            ]
            assert.throws(function () {(new LineChartInPlaceUpdater()).update(chart, newData)});
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
            var newData = { inplace : [
                { position: {x:0, y:0}, data: 'randomValue' },
                { position: {x:0, y:1}, data: 'randomValue' }
            ]};
            var updatedData = {
                datasets: [
                    {values: ['randomValue','randomValue',3,4]},
                    {values: [1,2,3,4]},
                    {values: [1,2,3,4]}
                ]
            };
            (new LineChartInPlaceUpdater()).update(chart, newData);
            assert.deepEqual(updatedData, chart.data);
        });
    });
});